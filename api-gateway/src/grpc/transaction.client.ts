import { grpc, loadProto } from './index.js';
import { env } from '../config/env.js';

type TxPkg = {
    transaction: {
        TransactionService: new (addr: string, creds: any) => {
            Transfer(
                req: { from_account_id: string; to_account_id: string; amount: number },
                cb: (err: Error | null, resp: { success: boolean; message: string }) => void,
            ): void;
            GetTransactionHistory(
                req: { account_id: string },
                cb: (
                    err: Error | null,
                    resp: { transactions: Array<{
                            transaction_id: string;
                            from_account_id: string;
                            to_account_id: string;
                            amount: number;
                            timestamp: string;
                        }> },
                ) => void,
            ): void;
        };
    };
};

const pkg = loadProto<TxPkg>('transaction.proto');

const address = `${env.TRANSACTION_HOST}:${env.TRANSACTION_PORT}`;
export const transactionClient = new pkg.transaction.TransactionService(
    address,
    grpc.credentials.createInsecure(),
);
