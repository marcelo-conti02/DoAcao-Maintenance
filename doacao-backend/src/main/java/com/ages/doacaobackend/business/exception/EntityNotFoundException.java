package com.ages.doacaobackend.business.exception;

import static com.ages.doacaobackend.controller.handler.logMessages.ErrorMessages.ENTITY_NOT_FOUND;

;

public class EntityNotFoundException extends Exception{
    
    public EntityNotFoundException(final String message) {
        super(String.format(ENTITY_NOT_FOUND, message));
    }

}
