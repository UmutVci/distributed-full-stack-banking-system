package com.umutavci.transactionservic.domain.ports;

import com.umutavci.transactionservic.domain.model.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionRepositoryPort {
    Transaction save(Transaction tx);
    List<Transaction> findByAccount(UUID accountId, int limit);
}
