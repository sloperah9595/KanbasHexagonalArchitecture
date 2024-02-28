package com.example.kanbas.domain.exceptions;

import org.springframework.http.HttpStatus;

public class BoardException extends RuntimeException {

    private final Integer code;
    private final String message;

    public BoardException(String message) {
        super(message);
        this.code = HttpStatus.BAD_REQUEST.value();
        this.message = message;
    }
}
