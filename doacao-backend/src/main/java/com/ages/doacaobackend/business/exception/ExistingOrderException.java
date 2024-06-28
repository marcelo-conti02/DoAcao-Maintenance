package com.ages.doacaobackend.business.exception;

public class ExistingOrderException extends Exception{
    public ExistingOrderException(String message) {
        super(message);
    }
}
