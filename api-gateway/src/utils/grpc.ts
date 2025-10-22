export function unary<TReq extends object, TResp>(
    client: any,
    methodName: string,
    req: TReq,
): Promise<TResp> {
    return new Promise((resolve, reject) => {
        client[methodName](req, (err: any, resp: TResp) => {
            if (err) return reject(err);
            resolve(resp);
        });
    });
}
