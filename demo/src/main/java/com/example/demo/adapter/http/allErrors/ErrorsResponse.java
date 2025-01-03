package com.example.demo.adapter.http.allErrors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorsResponse {

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("status")
    private int status;

    // Construtor genérico
    public ErrorsResponse(String message, int status) {
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
