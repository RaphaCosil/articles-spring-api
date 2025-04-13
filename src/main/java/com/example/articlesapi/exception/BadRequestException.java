package com.example.articlesapi.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super("Bad request " + message);
        int errorCode = 400;
    }
}
