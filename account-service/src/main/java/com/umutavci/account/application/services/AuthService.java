package com.umutavci.account.application.services;

import com.umutavci.account.application.dto.LoginRequestDTO;
import com.umutavci.account.application.dto.LoginResponseDTO;
import com.umutavci.account.application.dto.RegisterRequestDTO;
import com.umutavci.account.application.dto.RegisterResponseDTO;
import com.umutavci.account.infrastructure.persistence.AccountEntity;
import com.umutavci.account.infrastructure.persistence.AccountRepository;
import com.umutavci.account.infrastructure.persistence.AccountStatus;
import com.umutavci.account.infrastructure.persistence.AccountType;
import com.umutavci.account.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public RegisterResponseDTO register(RegisterRequestDTO req) {
        if (accountRepository.existsByOwnerEmail(req.getOwnerEmail())) {
            throw new IllegalArgumentException("Email already used");
        }

        AccountEntity account = AccountEntity.builder()
                .accountNumber(generateAccountNumber())
                .ownerName(req.getOwnerName())
                .ownerEmail(req.getOwnerEmail())
                .balance(BigDecimal.ZERO)
                .type(AccountType.valueOf(req.getAccountType().toUpperCase()))
                .status(AccountStatus.ACTIVE)
                // store hashed password in a dedicated field, e.g. passwordHash
                .passwordHash(passwordEncoder.encode(req.getPassword()))
                .build();

        AccountEntity saved = accountRepository.save(account);

        String token = jwtUtil.generateToken(saved.getOwnerEmail(), saved.getId());
        return RegisterResponseDTO.builder()
                .accountNumber(saved.getAccountNumber())
                .token(token)
                .build();
    }

    private String generateAccountNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        var account = accountRepository.findByOwnerEmail(request.getOwnerEmail())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (!passwordEncoder.matches(request.getPassword(), account.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        // 3️⃣ Token üret
        String token = jwtUtil.generateToken(account.getOwnerEmail(), account.getId());

        // 4️⃣ Response dön
        return LoginResponseDTO.builder()
                .accountNumber(account.getAccountNumber())
                .token(token)
                .build();
    }
}
