package com.umutavci.transactionservic.application.usecase;

import com.umutavci.transactionservic.domain.model.Transaction;
import com.umutavci.transactionservic.domain.ports.TransactionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTransactionHistoryUseCase {

    private final TransactionRepositoryPort txRepo;

    public List<Transaction> getTransactionsByAccountId(String accountId) {
        UUID id = UUID.fromString(accountId);
        return getTransactionsByAccountId(id, 10); // default 10 transaction
    }

    public List<Transaction> getTransactionsByAccountId(UUID accountId, int limit) {
        return txRepo.findByAccount(accountId, limit);
    }
}

