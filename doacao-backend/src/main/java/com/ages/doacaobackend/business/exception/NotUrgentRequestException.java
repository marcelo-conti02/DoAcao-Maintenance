package com.ages.doacaobackend.business.exception;

public class NotUrgentRequestException extends Exception {
    public NotUrgentRequestException(String message) {
        super(message);
    }
}
