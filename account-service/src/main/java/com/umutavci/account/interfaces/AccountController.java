package com.umutavci.account.interfaces;

import com.umutavci.account.application.services.AccountService;
import com.umutavci.account.infrastructure.persistence.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/me")
    public ResponseEntity<?> getMyBalance(Authentication authentication) {
        System.out.println("Auth object: " + authentication); // 👀
        if (authentication == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        String email = authentication.getName();
        AccountEntity account = accountService.findByEmail(email);
        if (account == null) {
            return ResponseEntity.status(404).body("Account not found");
        }
        return ResponseEntity.ok(
                new BalanceResponse(account.getAccountNumber(), account.getBalance())
        );
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getBalance(id));
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<Boolean> updateBalance(@PathVariable String id, @RequestParam double amount) {
        return ResponseEntity.ok(accountService.updateBalance(id, BigDecimal.valueOf(amount)));
    }

    private record BalanceResponse(String accountNumber, java.math.BigDecimal balance) {}
}
