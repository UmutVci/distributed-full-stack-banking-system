package com.umutavci.account.application.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private String accountNumber;
    private String token;
}
