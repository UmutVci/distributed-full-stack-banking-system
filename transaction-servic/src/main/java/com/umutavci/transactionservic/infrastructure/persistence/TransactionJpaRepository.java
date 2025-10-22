package com.umutavci.transactionservic.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findTop50ByFromAccountIdOrToAccountIdOrderByCreatedAtDesc(UUID fromId, UUID toId);
}

