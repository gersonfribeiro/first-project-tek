package com.example.demo.application.users;

import com.example.demo.domain.users.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersCreateDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("passwordUser")
    private String passwordUser;

    public Users toUser() {
        return new Users(username, email, passwordUser);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}
