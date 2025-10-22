package com.umutavci.transactionservic.infrastructure.persistence;

import com.umutavci.transactionservic.domain.model.Transaction;
import com.umutavci.transactionservic.domain.ports.TransactionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepositoryPort {

    private final TransactionJpaRepository repo;

    @Override
    public Transaction save(Transaction tx) {
        return repo.save(TransactionEntity.fromDomain(tx)).toDomain();
    }

    @Override
    public List<Transaction> findByAccount(UUID accountId, int limit) {
        return repo.findTop50ByFromAccountIdOrToAccountIdOrderByCreatedAtDesc(accountId, accountId)
                .stream()
                .limit(limit <= 0 ? 50 : limit)
                .map(TransactionEntity::toDomain)
                .toList();
    }
}
