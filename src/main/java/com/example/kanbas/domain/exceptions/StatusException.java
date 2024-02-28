package com.example.kanbas.domain.exceptions;

import org.springframework.http.HttpStatus;

public class StatusException extends RuntimeException {

    private final Integer code;
    private final String message;

    public StatusException(String message) {
        super(message);
        this.code = HttpStatus.BAD_REQUEST.value();
        this.message = message;
    }
}
