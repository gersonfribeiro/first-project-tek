package com.example.demo.application.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginDTO {
    @JsonProperty("email")
    private String email;

    @JsonProperty("passwordUser")
    private String passwordUser;
}
