package com.omnirio.customer.domain.models.dto;

import javax.validation.constraints.NotNull;

public class AuthRequest {

    @NotNull //@Email
    private String username;
    
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}