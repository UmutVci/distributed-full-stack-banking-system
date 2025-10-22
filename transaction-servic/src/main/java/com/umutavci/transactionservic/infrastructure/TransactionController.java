package com.umutavci.transactionservic.infrastructure;

import com.umutavci.transactionservic.application.usecase.TransferFundsUseCase;
import com.umutavci.transactionservic.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransferFundsUseCase transferFundsUseCase;

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody Map<String, Object> payload) {
        UUID from = UUID.fromString(payload.get("from_account_id").toString());
        UUID to = UUID.fromString(payload.get("to_account_id").toString());
        BigDecimal amount = new BigDecimal(payload.get("amount").toString());

        Transaction tx = transferFundsUseCase.transfer(from, to, amount);
        return ResponseEntity.ok(tx);
    }
}
