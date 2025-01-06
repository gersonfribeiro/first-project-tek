package com.example.demo.application.users.exceptions;

public class UsuarioEmailCadastradoException extends RuntimeException {

    private String email;

    public UsuarioEmailCadastradoException(String email) {
        super(String.format("The email: %s is already registered!", email));
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
