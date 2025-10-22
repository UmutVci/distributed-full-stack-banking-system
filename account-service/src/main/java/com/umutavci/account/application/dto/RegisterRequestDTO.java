package com.umutavci.account.application.dto;

import lombok.*;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class RegisterRequestDTO {
        private String ownerName;
        private String ownerEmail;
        private String password;
        private String accountType;
    }
