package com.example.demo.adapter.http.allErrors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("status")
    private int status;

    // Construtor genérico
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
