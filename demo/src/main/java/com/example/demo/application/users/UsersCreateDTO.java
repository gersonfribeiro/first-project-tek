package com.example.demo.application.users;

import com.example.demo.domain.users.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersCreateDTO {

    @JsonProperty("usernameUser")
    private String usernameUser;

    @JsonProperty("email")
    private String email;

    @JsonProperty("passwordUser")
    private String passwordUser;

    public Users toUser() {
        return new Users(usernameUser, email, passwordUser);
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}
