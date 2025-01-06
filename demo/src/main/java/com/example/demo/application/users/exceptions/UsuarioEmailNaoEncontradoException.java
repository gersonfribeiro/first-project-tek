package com.example.demo.application.users.exceptions;

public class UsuarioEmailNaoEncontradoException extends RuntimeException {

    private String email;

    public UsuarioEmailNaoEncontradoException(String email) {
        super(String.format("User not found for email: %s", email));
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
