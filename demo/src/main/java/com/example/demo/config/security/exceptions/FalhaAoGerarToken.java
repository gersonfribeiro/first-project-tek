package com.example.demo.config.security.exceptions;

public class FalhaAoGerarToken extends RuntimeException {
    public FalhaAoGerarToken() {
        super("Failed to generate token!");
    }
}
