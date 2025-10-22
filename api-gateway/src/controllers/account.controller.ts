import { Request, Response, NextFunction } from 'express';
import { accountClient } from '../grpc/account.client.js';
import { unary } from '../utils/grpc.js';
import { z } from 'zod';

export async function getBalance(req: Request, res: Response, next: NextFunction) {
    try {
        const params = z.object({ id: z.string().min(1) }).parse(req.params);
        const resp = await unary<{ account_id: string }, { balance: number }>(
            accountClient,
            'GetBalance',
            { account_id: params.id },
        );
        res.json(resp);
    } catch (err) {
        next(err);
    }
}

export async function updateBalance(req: Request, res: Response, next: NextFunction) {
    try {
        const body = z.object({
            account_id: z.string().min(1),
            amount: z.number(),
        }).parse(req.body);

        const resp = await unary<{ account_id: string; amount: number }, { success: boolean }>(
            accountClient,
            'UpdateBalance',
            body,
        );
        res.json(resp);
    } catch (err) {
        next(err);
    }
}
