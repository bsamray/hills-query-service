package com.exercise.tech.hills.exception;

public class InvalidApiRequestException extends RuntimeException {

    public InvalidApiRequestException(String msg) {
        super(msg);
    }

}
