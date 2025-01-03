package com.example.demo.application.users;

import com.example.demo.domain.users.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersUpdateDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

    @JsonProperty("passwordUser")
    private String passwordUser;

    public Users toUser(int id_user) {
        return new Users(id_user, username, email, passwordUser);
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
