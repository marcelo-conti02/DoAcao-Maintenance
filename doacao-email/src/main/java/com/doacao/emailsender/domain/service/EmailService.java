package com.doacao.emailsender.domain.service;

import com.doacao.emailsender.domain.crypto.Crypter;
import com.doacao.emailsender.domain.data.EmailSender;
import com.doacao.emailsender.domain.data.EmailShippingRequest;

import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.*;

import static javax.mail.Message.RecipientType.TO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailService {

    private static final String LOG = "[%s] email succesfully sent to %s."; 

    private final Crypter crypter;

    public EmailService(final Crypter crypter) {
        this.crypter = crypter;
    }

    public String encodeString(final String message) {
        return crypter.encode(message);
    }

    /**
     * @param password needs to be generated as an app Password (https://support.microsoft.com/en-us/account-billing/using-app-passwords-with-apps-that-don-t-support-two-step-verification-5896ed9b-4263-e681-128a-a6f2979a7944),
     * currently not decrypted but will be in the future
     * @throws DecoderException
     */

    public void sendEmail(final EmailShippingRequest request, final String password) throws MessagingException, DecoderException {
        final EmailSender sender = new EmailSender(request.getUser(), password); 
        MimeMessage message = new MimeMessage(sender.getSession());
        message.setFrom(new InternetAddress(request.getUser()));
        message.addRecipient(TO, new InternetAddress(request.getRecipient()));
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        Transport.send(message);
        logDeparture(request.getRecipient());
    }

    private void logDeparture(final String recipient) {
        String currTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SSS"));
        System.out.println(String.format(LOG, currTime, recipient));
    }
}
