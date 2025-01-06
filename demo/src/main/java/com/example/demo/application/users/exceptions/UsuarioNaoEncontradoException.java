package com.example.demo.application.users.exceptions;

public class UsuarioNaoEncontradoException  extends RuntimeException {

    public UsuarioNaoEncontradoException() {
        super("User not found!");
    }
}
