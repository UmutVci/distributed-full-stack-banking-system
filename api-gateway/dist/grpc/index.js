import path from 'node:path';
import * as grpc from '@grpc/grpc-js';
import * as protoLoader from '@grpc/proto-loader';
const loaderOptions = {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true,
};
export function loadProto(relativePath) {
    const protoPath = path.resolve(process.cwd(), 'protos', relativePath);
    const def = protoLoader.loadSync(protoPath, loaderOptions);
    return grpc.loadPackageDefinition(def);
}
export { grpc };
