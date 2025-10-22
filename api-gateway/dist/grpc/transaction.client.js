import { grpc, loadProto } from './index.js';
import { env } from '../config/env.js';
const pkg = loadProto('transaction.proto');
const address = `${env.TRANSACTION_HOST}:${env.TRANSACTION_PORT}`;
export const transactionClient = new pkg.transaction.TransactionService(address, grpc.credentials.createInsecure());
