package com.example.articlesapi.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad request");
        int errorCode = 400;
    }
}
