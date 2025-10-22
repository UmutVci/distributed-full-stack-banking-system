package com.umutavci.transactionservic.infrastructure.grpc.server;

import com.umutavci.transactionservic.application.usecase.GetTransactionHistoryUseCase;
import com.umutavci.transactionservic.application.usecase.TransferFundsUseCase;
import com.umutavci.transactionservic.domain.model.Transaction;
import com.umutavci.transactionservic.grpc.TransactionHistoryRequest;
import com.umutavci.transactionservic.grpc.TransactionHistoryResponse;
import com.umutavci.transactionservic.grpc.TransactionServiceGrpc;
import com.umutavci.transactionservic.grpc.TransferRequest;
import com.umutavci.transactionservic.grpc.TransferResponse;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class TransactionGrpcService extends TransactionServiceGrpc.TransactionServiceImplBase {

    private final TransferFundsUseCase transferFundsUseCase;
    private final GetTransactionHistoryUseCase getTransactionHistoryUseCase;

    @Override
    public void transfer(TransferRequest request, StreamObserver<TransferResponse> responseObserver) {
        var tx = transferFundsUseCase.transfer(
                UUID.fromString(request.getFromAccountId()),
                UUID.fromString(request.getToAccountId()),
                BigDecimal.valueOf(request.getAmount())
        );

        boolean success = tx.getStatus().name().equals("SUCCESS");
        String message = success ? "OK" : "FAILED";

        responseObserver.onNext(TransferResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getTransactionHistory(TransactionHistoryRequest request,
                                      StreamObserver<TransactionHistoryResponse> responseObserver) {

        List<Transaction> transactions = getTransactionHistoryUseCase.getTransactionsByAccountId(request.getAccountId());

        TransactionHistoryResponse.Builder responseBuilder = TransactionHistoryResponse.newBuilder();

        for (Transaction t : transactions) {
            responseBuilder.addTransactions(
                    com.umutavci.transactionservic.grpc.Transaction.newBuilder()
                            .setTransactionId(t.getId().toString())
                            .setFromAccountId(t.getFromAccountId().toString())
                            .setToAccountId(t.getToAccountId().toString())
                            .setAmount(t.getAmount().doubleValue())
                            .setTimestamp(t.getCreatedAt().toString())
                            .build()
            );
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
