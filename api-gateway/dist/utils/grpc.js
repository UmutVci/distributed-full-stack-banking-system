export function unary(client, methodName, req) {
    return new Promise((resolve, reject) => {
        client[methodName](req, (err, resp) => {
            if (err)
                return reject(err);
            resolve(resp);
        });
    });
}
