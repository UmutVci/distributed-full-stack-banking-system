package com.umutavci.transactionservic.infrastructure.grpc.client;

import com.umutavci.account.grpc.AccountServiceGrpc;
import com.umutavci.account.grpc.GetBalanceRequest;
import com.umutavci.account.grpc.GetBalanceResponse;
import com.umutavci.account.grpc.UpdateBalanceRequest;
import com.umutavci.account.grpc.UpdateBalanceResponse;
import com.umutavci.transactionservic.domain.ports.AccountPort;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class AccountGrpcClient implements AccountPort {

    @GrpcClient("accountService")
    private AccountServiceGrpc.AccountServiceBlockingStub accountStub;

    @Override
    public BigDecimal getBalance(UUID accountId) {
        try {
            GetBalanceResponse response = accountStub.getBalance(
                    GetBalanceRequest.newBuilder()
                            .setAccountId(accountId.toString())
                            .build()
            );
            return BigDecimal.valueOf(response.getBalance());
        } catch (StatusRuntimeException e) {
            log.error("getBalance failed for {}: {}", accountId, e.getStatus().getDescription());
            return BigDecimal.ZERO;
        }
    }

    @Override
    public boolean applyChange(UUID accountId, BigDecimal amount) {
        try {
            UpdateBalanceResponse response = accountStub.updateBalance(
                    UpdateBalanceRequest.newBuilder()
                            .setAccountId(accountId.toString())
                            .setAmount(amount.doubleValue())
                            .build()
            );
            return response.getSuccess();
        } catch (StatusRuntimeException e) {
            log.error("updateBalance failed for {}: {}", accountId, e.getStatus().getDescription());
            return false;
        }
    }
}