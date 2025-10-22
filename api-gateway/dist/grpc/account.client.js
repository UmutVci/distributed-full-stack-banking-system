import { grpc, loadProto } from './index.js';
import { env } from '../config/env.js';
const pkg = loadProto('account.proto');
const address = `${env.ACCOUNT_HOST}:${env.ACCOUNT_PORT}`;
export const accountClient = new pkg.account.AccountService(address, grpc.credentials.createInsecure());
