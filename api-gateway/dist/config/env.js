import 'dotenv/config';
export const env = {
    PORT: Number(process.env.PORT ?? 8080),
    ACCOUNT_HOST: process.env.ACCOUNT_SERVICE_HOST ?? 'account-service',
    ACCOUNT_PORT: Number(process.env.ACCOUNT_SERVICE_PORT ?? 9090),
    TRANSACTION_HOST: process.env.TRANSACTION_SERVICE_HOST ?? 'transaction-servic',
    TRANSACTION_PORT: Number(process.env.TRANSACTION_SERVICE_PORT ?? 9091),
};
