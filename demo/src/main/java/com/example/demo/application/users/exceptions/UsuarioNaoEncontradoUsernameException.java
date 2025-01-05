package com.example.demo.application.users.exceptions;

public class UsuarioNaoEncontradoUsernameException extends RuntimeException {
    private String username;

    public UsuarioNaoEncontradoUsernameException(String username) {
        super(String.format("User not found for username: %s", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
