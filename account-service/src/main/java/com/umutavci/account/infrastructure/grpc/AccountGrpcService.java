package com.umutavci.account.infrastructure.grpc;

import com.umutavci.account.application.services.AccountService;
import com.umutavci.account.grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService; // Spring Boot gRPC server
import java.math.BigDecimal;

@Slf4j
@GrpcService
public class AccountGrpcService extends AccountServiceGrpc.AccountServiceImplBase {

    private final AccountService accountService;

    public AccountGrpcService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void getBalance(GetBalanceRequest request,
                           StreamObserver<GetBalanceResponse> responseObserver) {
        try {
            BigDecimal balance = accountService.getBalance(request.getAccountId());

            GetBalanceResponse response = GetBalanceResponse.newBuilder()
                    .setBalance(balance.doubleValue())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateBalance(UpdateBalanceRequest request,
                              StreamObserver<UpdateBalanceResponse> responseObserver) {
        try {
            boolean success = accountService.updateBalance(
                    request.getAccountId(),
                    BigDecimal.valueOf(request.getAmount())
            );

            UpdateBalanceResponse response = UpdateBalanceResponse.newBuilder()
                    .setSuccess(success)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            log.error("updateBalance failed for {}: {}", request.getAccountId(), e.getMessage(), e);
            responseObserver.onError(e);
        }
    }

}