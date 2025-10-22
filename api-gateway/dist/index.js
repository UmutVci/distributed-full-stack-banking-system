import express from 'express';
import { env } from './config/env.js';
import { healthRouter } from './routes/health.routes.js';
import { accountRouter } from './routes/account.routes.js';
import { transactionRouter } from './routes/transaction.routes.js';
import { errorHandler } from './middlewares/error.js';
const app = express();
app.use(express.json());
// Routes
app.use('/api', healthRouter);
app.use('/api/accounts', accountRouter);
app.use('/api/transactions', transactionRouter);
// Errors
app.use(errorHandler);
app.listen(env.PORT, () => {
    console.log(`API Gateway is running on :${env.PORT} | ` +
        `account@${env.ACCOUNT_HOST}:${env.ACCOUNT_PORT} | ` +
        `transaction@${env.TRANSACTION_HOST}:${env.TRANSACTION_PORT}`);
});
