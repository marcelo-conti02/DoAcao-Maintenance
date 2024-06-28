package com.doacao.emailsender.application.controllers;

import com.doacao.emailsender.domain.service.EmailService;

import org.apache.commons.codec.DecoderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.doacao.emailsender.domain.data.EmailShippingRequest;
import javax.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    @PostMapping
    public void sendEmail(@RequestHeader final String password, @RequestBody final EmailShippingRequest request) throws MessagingException, DecoderException {
        emailService.sendEmail(request, password);
    }

    @GetMapping
    public ResponseEntity<String> encode(@RequestHeader final String message) throws MessagingException, DecoderException {
        return new ResponseEntity<>(emailService.encodeString(message), HttpStatus.OK);
    }
}
