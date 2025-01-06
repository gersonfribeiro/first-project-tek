package com.example.demo.application.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseDTO {
    
    @JsonProperty("token")
    private String token;

    public LoginResponseDTO(String token) {
    }
}
