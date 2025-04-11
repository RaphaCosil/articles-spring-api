package com.example.articlesapi.exception;

public class InternalServerException extends RuntimeException {
    public InternalServerException() {
        super("Internal server error");
        int errorCode = 500;
    }
}
