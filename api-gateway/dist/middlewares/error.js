export function errorHandler(err, _req, res, _next) {
    const status = (err?.code && typeof err.code === 'number') ? 502 : 400;
    const message = err?.details || err?.message || 'Unknown error';
    res.status(status).json({ error: message });
}
