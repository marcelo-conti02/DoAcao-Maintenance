package com.ages.doacaobackend.business.exception;

public class ExistingUserException extends Exception{
    public ExistingUserException(String message) {
        super(message);
    }
}
