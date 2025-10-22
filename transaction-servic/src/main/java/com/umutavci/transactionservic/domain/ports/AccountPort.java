package com.umutavci.transactionservic.domain.ports;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountPort {
    BigDecimal getBalance(UUID accountId);
    boolean applyChange(UUID accountId, BigDecimal amount); // +credit, -debit
}
