package com.ages.doacaobackend.business.exception;


public class DuplicateProductException extends Exception{
    public DuplicateProductException(String message) {
        super(message);
    }
}
