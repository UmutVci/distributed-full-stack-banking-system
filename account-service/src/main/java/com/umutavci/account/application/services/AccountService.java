package com.umutavci.account.application.services;

import com.umutavci.account.infrastructure.persistence.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private AccountEntity loadByIdOrNumber(String key) {
        // UUID ise id’den getir
        try {
            UUID id = UUID.fromString(key);
            return accountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Account not found by id: " + key));
        } catch (IllegalArgumentException ignore) {
            // UUID değilse account_number’dan getir
            return accountRepository.findByAccountNumber(key)
                    .orElseThrow(() -> new RuntimeException("Account not found by accountNumber: " + key));
        }
    }

    public BigDecimal getBalance(String accountIdOrNumber) {
        AccountEntity account = loadByIdOrNumber(accountIdOrNumber);
        return account.getBalance();
    }

    public boolean updateBalance(String accountIdOrNumber, BigDecimal amount) {
        AccountEntity account = loadByIdOrNumber(accountIdOrNumber);

        BigDecimal newBalance = account.getBalance().add(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        account.setBalance(newBalance);
        accountRepository.save(account);
        return true;
    }

    public AccountEntity createAccount(String ownerName, String ownerEmail, AccountType type) {
        AccountEntity account = AccountEntity.builder()
                .accountNumber(UUID.randomUUID().toString().substring(0, 12))
                .ownerName(ownerName)
                .ownerEmail(ownerEmail)
                .balance(BigDecimal.ZERO)
                .type(type)
                .status(AccountStatus.ACTIVE)
                .build();

        return accountRepository.save(account);
    }

    public AccountEntity findByEmail(String email){
        return accountRepository.findByOwnerEmail(email).orElseThrow(
                () -> new EntityNotFoundException("Account with this email not found")
        );
    }
}

