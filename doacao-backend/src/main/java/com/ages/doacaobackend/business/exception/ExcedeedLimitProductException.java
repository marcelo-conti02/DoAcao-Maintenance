package com.ages.doacaobackend.business.exception;

public class ExcedeedLimitProductException extends Exception{
    public ExcedeedLimitProductException(String message) {
        super(message);
    }
}
