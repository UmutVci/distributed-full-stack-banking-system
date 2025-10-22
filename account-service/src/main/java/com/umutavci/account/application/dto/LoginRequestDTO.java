package com.umutavci.account.application.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String ownerEmail;
    private String password;
}
