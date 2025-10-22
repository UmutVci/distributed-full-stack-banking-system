import { Request, Response, NextFunction } from 'express';

export function errorHandler(err: any, _req: Request, res: Response, _next: NextFunction) {
    const status = (err?.code && typeof err.code === 'number') ? 502 : 400;
    const message = err?.details || err?.message || 'Unknown error';
    res.status(status).json({ error: message });
}
