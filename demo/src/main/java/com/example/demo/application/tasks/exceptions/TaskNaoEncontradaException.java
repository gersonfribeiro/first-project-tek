package com.example.demo.application.tasks.exceptions;

public class TaskNaoEncontradaException extends RuntimeException {

    public TaskNaoEncontradaException() {
        super("Task not found!");
    }
}
