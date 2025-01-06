package com.example.demo.adapter.http.allErrors;

import com.example.demo.application.tasks.exceptions.TaskNaoEncontradaException;
import com.example.demo.application.users.exceptions.UsuarioEmailCadastradoException;
import com.example.demo.application.users.exceptions.UsuarioEmailNaoEncontradoException;
import com.example.demo.application.users.exceptions.UsuarioNaoEncontradoException;
import com.example.demo.application.users.exceptions.UsuarioNaoEncontradoUsernameException;
import com.example.demo.config.security.exceptions.FalhaAoGerarToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UsuarioEmailCadastradoException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioEmailCadastradoException(UsuarioEmailCadastradoException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioEmailNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioEmailNaoEncontradoException(UsuarioEmailNaoEncontradoException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNaoEncontradoUsernameException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNaoEncontradoUsernameException(UsuarioNaoEncontradoUsernameException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNaoEncontradaException.class)
    public ResponseEntity<ErrorResponse> handleTaskNaoEncontradaException(TaskNaoEncontradaException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FalhaAoGerarToken.class)
    public ResponseEntity<ErrorResponse> handleFalhaAoGerarToken(FalhaAoGerarToken e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
