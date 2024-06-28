package com.ages.doacaobackend.business.exception;

import java.util.List;

public class MalformedEntityException extends Exception{

    List<String> errorMessages;

    public MalformedEntityException(List errorMessages) {
        super("Valores inválidos designados para campo validado");
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
