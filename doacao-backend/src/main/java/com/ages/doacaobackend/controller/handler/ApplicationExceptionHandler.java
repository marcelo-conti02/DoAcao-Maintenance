package com.ages.doacaobackend.controller.handler;

import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ExistingCNPJException;
import com.ages.doacaobackend.business.exception.ExistingUserException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.controller.handler.errorBody.ErrorBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MalformedEntityException.class)
    public ResponseEntity<ErrorBody> handleMalformedEntityException(final MalformedEntityException exception) {
        System.err.println(exception.getMessage());
        return new ResponseEntity<>(new ErrorBody(exception.getErrorMessages()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(final Exception exception) {
        System.err.println(exception.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistingCNPJException.class)
    public ResponseEntity<?> handleExistingCNPJException(final Exception exception) {
        System.err.println(exception.getMessage());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExistingUserException.class)
    public ResponseEntity handleExistingUserException(final Exception exception) {
        System.err.println(exception.getMessage());
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
