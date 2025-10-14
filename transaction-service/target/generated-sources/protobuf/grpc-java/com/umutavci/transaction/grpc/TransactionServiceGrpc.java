package com.umutavci.transaction.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: transaction.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TransactionServiceGrpc {

  private TransactionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "transaction.TransactionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.umutavci.transaction.grpc.TransferRequest,
      com.umutavci.transaction.grpc.TransferResponse> getTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Transfer",
      requestType = com.umutavci.transaction.grpc.TransferRequest.class,
      responseType = com.umutavci.transaction.grpc.TransferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.umutavci.transaction.grpc.TransferRequest,
      com.umutavci.transaction.grpc.TransferResponse> getTransferMethod() {
    io.grpc.MethodDescriptor<com.umutavci.transaction.grpc.TransferRequest, com.umutavci.transaction.grpc.TransferResponse> getTransferMethod;
    if ((getTransferMethod = TransactionServiceGrpc.getTransferMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getTransferMethod = TransactionServiceGrpc.getTransferMethod) == null) {
          TransactionServiceGrpc.getTransferMethod = getTransferMethod =
              io.grpc.MethodDescriptor.<com.umutavci.transaction.grpc.TransferRequest, com.umutavci.transaction.grpc.TransferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Transfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.umutavci.transaction.grpc.TransferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.umutavci.transaction.grpc.TransferResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("Transfer"))
              .build();
        }
      }
    }
    return getTransferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.umutavci.transaction.grpc.TransactionHistoryRequest,
      com.umutavci.transaction.grpc.TransactionHistoryResponse> getGetTransactionHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransactionHistory",
      requestType = com.umutavci.transaction.grpc.TransactionHistoryRequest.class,
      responseType = com.umutavci.transaction.grpc.TransactionHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.umutavci.transaction.grpc.TransactionHistoryRequest,
      com.umutavci.transaction.grpc.TransactionHistoryResponse> getGetTransactionHistoryMethod() {
    io.grpc.MethodDescriptor<com.umutavci.transaction.grpc.TransactionHistoryRequest, com.umutavci.transaction.grpc.TransactionHistoryResponse> getGetTransactionHistoryMethod;
    if ((getGetTransactionHistoryMethod = TransactionServiceGrpc.getGetTransactionHistoryMethod) == null) {
      synchronized (TransactionServiceGrpc.class) {
        if ((getGetTransactionHistoryMethod = TransactionServiceGrpc.getGetTransactionHistoryMethod) == null) {
          TransactionServiceGrpc.getGetTransactionHistoryMethod = getGetTransactionHistoryMethod =
              io.grpc.MethodDescriptor.<com.umutavci.transaction.grpc.TransactionHistoryRequest, com.umutavci.transaction.grpc.TransactionHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransactionHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.umutavci.transaction.grpc.TransactionHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.umutavci.transaction.grpc.TransactionHistoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TransactionServiceMethodDescriptorSupplier("GetTransactionHistory"))
              .build();
        }
      }
    }
    return getGetTransactionHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransactionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionServiceStub>() {
        @java.lang.Override
        public TransactionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionServiceStub(channel, callOptions);
        }
      };
    return TransactionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransactionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionServiceBlockingStub>() {
        @java.lang.Override
        public TransactionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionServiceBlockingStub(channel, callOptions);
        }
      };
    return TransactionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransactionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TransactionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TransactionServiceFutureStub>() {
        @java.lang.Override
        public TransactionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TransactionServiceFutureStub(channel, callOptions);
        }
      };
    return TransactionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void transfer(com.umutavci.transaction.grpc.TransferRequest request,
        io.grpc.stub.StreamObserver<com.umutavci.transaction.grpc.TransferResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransferMethod(), responseObserver);
    }

    /**
     */
    default void getTransactionHistory(com.umutavci.transaction.grpc.TransactionHistoryRequest request,
        io.grpc.stub.StreamObserver<com.umutavci.transaction.grpc.TransactionHistoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransactionHistoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TransactionService.
   */
  public static abstract class TransactionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TransactionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TransactionService.
   */
  public static final class TransactionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TransactionServiceStub> {
    private TransactionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionServiceStub(channel, callOptions);
    }

    /**
     */
    public void transfer(com.umutavci.transaction.grpc.TransferRequest request,
        io.grpc.stub.StreamObserver<com.umutavci.transaction.grpc.TransferResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionHistory(com.umutavci.transaction.grpc.TransactionHistoryRequest request,
        io.grpc.stub.StreamObserver<com.umutavci.transaction.grpc.TransactionHistoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransactionHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TransactionService.
   */
  public static final class TransactionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TransactionServiceBlockingStub> {
    private TransactionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.umutavci.transaction.grpc.TransferResponse transfer(com.umutavci.transaction.grpc.TransferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransferMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.umutavci.transaction.grpc.TransactionHistoryResponse getTransactionHistory(com.umutavci.transaction.grpc.TransactionHistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransactionHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TransactionService.
   */
  public static final class TransactionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TransactionServiceFutureStub> {
    private TransactionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransactionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TransactionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.umutavci.transaction.grpc.TransferResponse> transfer(
        com.umutavci.transaction.grpc.TransferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.umutavci.transaction.grpc.TransactionHistoryResponse> getTransactionHistory(
        com.umutavci.transaction.grpc.TransactionHistoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransactionHistoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSFER = 0;
  private static final int METHODID_GET_TRANSACTION_HISTORY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRANSFER:
          serviceImpl.transfer((com.umutavci.transaction.grpc.TransferRequest) request,
              (io.grpc.stub.StreamObserver<com.umutavci.transaction.grpc.TransferResponse>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_HISTORY:
          serviceImpl.getTransactionHistory((com.umutavci.transaction.grpc.TransactionHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.umutavci.transaction.grpc.TransactionHistoryResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getTransferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.umutavci.transaction.grpc.TransferRequest,
              com.umutavci.transaction.grpc.TransferResponse>(
                service, METHODID_TRANSFER)))
        .addMethod(
          getGetTransactionHistoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.umutavci.transaction.grpc.TransactionHistoryRequest,
              com.umutavci.transaction.grpc.TransactionHistoryResponse>(
                service, METHODID_GET_TRANSACTION_HISTORY)))
        .build();
  }

  private static abstract class TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TransactionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.umutavci.transaction.grpc.TransactionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TransactionService");
    }
  }

  private static final class TransactionServiceFileDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier {
    TransactionServiceFileDescriptorSupplier() {}
  }

  private static final class TransactionServiceMethodDescriptorSupplier
      extends TransactionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TransactionServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransactionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransactionServiceFileDescriptorSupplier())
              .addMethod(getTransferMethod())
              .addMethod(getGetTransactionHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
