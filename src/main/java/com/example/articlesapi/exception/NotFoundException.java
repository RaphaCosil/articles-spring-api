package com.example.articlesapi.exception;

public class NotFoundException extends RuntimeException {
    private final int errorCode;
    public NotFoundException() {
        super("Resource not found");
        this.errorCode = 404;
    }
}
