package com.umutavci.transactionservic.application.usecase;

import com.umutavci.transactionservic.domain.model.Transaction;
import com.umutavci.transactionservic.domain.model.TransactionStatus;
import com.umutavci.transactionservic.domain.ports.AccountPort;
import com.umutavci.transactionservic.domain.ports.TransactionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransferFundsUseCase {

    private final AccountPort accountPort;
    private final TransactionRepositoryPort txRepo;

    @Transactional
    public Transaction transfer(UUID from, UUID to, BigDecimal amount) {
        if (amount.signum() <= 0) {
            return record(from, to, amount, TransactionStatus.FAILED, "Amount must be positive");
        }
        boolean debited = accountPort.applyChange(from, amount.negate());
        if (!debited) {
            return record(from, to, amount, TransactionStatus.FAILED, "Debit failed / insufficient funds");
        }
        boolean credited = accountPort.applyChange(to, amount);
        if (!credited) {
            accountPort.applyChange(from, amount);
            return record(from, to, amount, TransactionStatus.FAILED, "Credit failed");
        }
        return record(from, to, amount, TransactionStatus.SUCCESS, "OK");
    }

    private Transaction record(UUID from, UUID to, BigDecimal amount, TransactionStatus status, String msg) {
        Transaction tx = Transaction.builder()
                .id(UUID.randomUUID())
                .fromAccountId(from)
                .toAccountId(to)
                .amount(amount)
                .createdAt(Instant.now())
                .status(status)
                .build();
        return txRepo.save(tx);
    }
}
