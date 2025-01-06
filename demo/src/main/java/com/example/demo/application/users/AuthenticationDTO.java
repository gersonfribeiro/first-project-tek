package com.example.demo.application.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationDTO {

    @JsonProperty("emailUser")
    String emailUser;

    @JsonProperty("passwordUser")
    String passwordUser;

    public AuthenticationDTO(String emailUser, String passwordUser) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}
