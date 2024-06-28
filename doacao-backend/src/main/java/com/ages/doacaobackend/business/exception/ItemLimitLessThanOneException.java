package com.ages.doacaobackend.business.exception;

public class ItemLimitLessThanOneException extends Exception {
    public ItemLimitLessThanOneException(String message) {
        super(message);
    }
}
