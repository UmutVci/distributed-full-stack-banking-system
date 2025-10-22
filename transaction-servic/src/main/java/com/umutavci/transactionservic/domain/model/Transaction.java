package com.umutavci.transactionservic.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    UUID id;
    UUID fromAccountId;
    UUID toAccountId;
    BigDecimal amount;
    Instant createdAt;
    TransactionStatus status;
}
