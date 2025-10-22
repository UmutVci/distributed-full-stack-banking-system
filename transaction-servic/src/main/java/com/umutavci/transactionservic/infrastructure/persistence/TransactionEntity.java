package com.umutavci.transactionservic.infrastructure.persistence;

import com.umutavci.transactionservic.domain.model.Transaction;
import com.umutavci.transactionservic.domain.model.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "from_account_id", nullable = false, columnDefinition = "uuid")
    private UUID fromAccountId;

    @Column(name = "to_account_id", nullable = false, columnDefinition = "uuid")
    private UUID toAccountId;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    public static TransactionEntity fromDomain(Transaction d) {
        return TransactionEntity.builder()
                .id(d.getId())
                .fromAccountId(d.getFromAccountId())
                .toAccountId(d.getToAccountId())
                .amount(d.getAmount())
                .createdAt(d.getCreatedAt())
                .status(d.getStatus())
                .build();
    }

    public Transaction toDomain() {
        return Transaction.builder()
                .id(id)
                .fromAccountId(fromAccountId)
                .toAccountId(toAccountId)
                .amount(amount)
                .createdAt(createdAt)
                .status(status)
                .build();
    }
}
