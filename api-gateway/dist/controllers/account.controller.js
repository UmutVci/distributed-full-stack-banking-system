import { accountClient } from '../grpc/account.client.js';
import { unary } from '../utils/grpc.js';
import { z } from 'zod';
export async function getBalance(req, res, next) {
    try {
        const params = z.object({ id: z.string().min(1) }).parse(req.params);
        const resp = await unary(accountClient, 'GetBalance', { account_id: params.id });
        res.json(resp);
    }
    catch (err) {
        next(err);
    }
}
export async function updateBalance(req, res, next) {
    try {
        const body = z.object({
            account_id: z.string().min(1),
            amount: z.number(),
        }).parse(req.body);
        const resp = await unary(accountClient, 'UpdateBalance', body);
        res.json(resp);
    }
    catch (err) {
        next(err);
    }
}
