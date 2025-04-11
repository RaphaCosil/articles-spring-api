package com.example.articlesapi.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Resource not found");
        int errorCode = 404;
    }
}
