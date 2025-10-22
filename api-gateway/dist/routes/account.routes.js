import { Router } from 'express';
import { getBalance, updateBalance } from '../controllers/account.controller.js';
export const accountRouter = Router();
accountRouter.get('/:id/balance', getBalance);
accountRouter.post('/balance', updateBalance);
