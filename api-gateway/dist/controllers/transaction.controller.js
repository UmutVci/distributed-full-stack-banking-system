import { transactionClient } from '../grpc/transaction.client.js';
import { unary } from '../utils/grpc.js';
import { z } from 'zod';
export async function transfer(req, res, next) {
    try {
        const body = z.object({
            from_account_id: z.string().min(1),
            to_account_id: z.string().min(1),
            amount: z.number().positive(),
        }).parse(req.body);
        const resp = await unary(transactionClient, 'Transfer', body);
        res.status(resp.success ? 200 : 400).json(resp);
    }
    catch (err) {
        next(err);
    }
}
export async function history(req, res, next) {
    try {
        const params = z.object({ accountId: z.string().min(1) }).parse(req.params);
        const resp = await unary(transactionClient, 'GetTransactionHistory', { account_id: params.accountId });
        res.json(resp);
    }
    catch (err) {
        next(err);
    }
}
