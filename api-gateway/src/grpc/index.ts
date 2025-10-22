import path from 'node:path';
import * as grpc from '@grpc/grpc-js';
import * as protoLoader from '@grpc/proto-loader';

export type LoadedProto<T = any> = T;

const loaderOptions: protoLoader.Options = {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true,
};

export function loadProto<T = any>(relativePath: string): LoadedProto<T> {
    const protoPath = path.resolve(process.cwd(), 'protos', relativePath);
    const def = protoLoader.loadSync(protoPath, loaderOptions);
    return (grpc.loadPackageDefinition(def) as unknown) as T;
}

export { grpc };
