package com.doacao.emailsender.application.controllers.handler;

import static org.springframework.http.ResponseEntity.internalServerError;

import org.apache.commons.codec.DecoderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.mail.MessagingException;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<String> handleMessagingException(final MessagingException exception) {
        return internalServerError().build();
    }
    
    @ExceptionHandler(DecoderException.class)
    public ResponseEntity<String> handleDecoderException(final DecoderException exception) {
        return internalServerError().build();
    }

}