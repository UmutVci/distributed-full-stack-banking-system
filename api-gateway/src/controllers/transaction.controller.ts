import { Request, Response, NextFunction } from 'express';
import { transactionClient } from '../grpc/transaction.client.js';
import { unary } from '../utils/grpc.js';
import { z } from 'zod';

export async function transfer(req: Request, res: Response, next: NextFunction) {
    try {
        const body = z.object({
            from_account_id: z.string().min(1),
            to_account_id: z.string().min(1),
            amount: z.number().positive(),
        }).parse(req.body);

        const resp = await unary<
            { from_account_id: string; to_account_id: string; amount: number },
            { success: boolean; message: string }
        >(transactionClient, 'Transfer', body);

        res.status(resp.success ? 200 : 400).json(resp);
    } catch (err) {
        next(err);
    }
}

export async function history(req: Request, res: Response, next: NextFunction) {
    try {
        const params = z.object({ accountId: z.string().min(1) }).parse(req.params);

        const resp = await unary<
            { account_id: string },
            { transactions: Array<any> }
        >(transactionClient, 'GetTransactionHistory', { account_id: params.accountId });

        res.json(resp);
    } catch (err) {
        next(err);
    }
}
