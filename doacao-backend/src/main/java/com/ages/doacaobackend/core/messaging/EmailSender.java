package com.ages.doacaobackend.core.messaging;

import com.ages.doacaobackend.business.email.EmailEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailSender {
    
    private final String url;
    private final String user;
    private final String password;

    public EmailSender(
        @Value("${email.url}") final String url, 
        @Value("${email.user}") final String user,
        @Value("${email.password}") final String password ) {
        this.url = url;
        this.user = user;
        this.password = password;
    } 

    public void sendEmail(final String message, final String subject, final String recipient) {
        RestTemplate template = new RestTemplate();
        LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("password", password);
        EmailEntity emailBody = new EmailEntity(user, message, subject, recipient);
        HttpEntity<EmailEntity> email = new HttpEntity<EmailEntity>(emailBody, headers);
        try {
            ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, email, String.class);
            System.out.println("Response: " + response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email", e);
        }
    }
}