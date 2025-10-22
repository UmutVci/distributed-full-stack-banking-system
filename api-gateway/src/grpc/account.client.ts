import { grpc, loadProto } from './index.js';
import { env } from '../config/env.js';

type AccountPkg = {
    account: {
        AccountService: new (addr: string, creds: any) => {
            GetBalance(
                req: { account_id: string },
                cb: (err: Error | null, resp: { balance: number }) => void,
            ): void;
            UpdateBalance(
                req: { account_id: string; amount: number },
                cb: (err: Error | null, resp: { success: boolean }) => void,
            ): void;
        };
    };
};

const pkg = loadProto<AccountPkg>('account.proto');

const address = `${env.ACCOUNT_HOST}:${env.ACCOUNT_PORT}`;
export const accountClient = new pkg.account.AccountService(
    address,
    grpc.credentials.createInsecure(),
);
