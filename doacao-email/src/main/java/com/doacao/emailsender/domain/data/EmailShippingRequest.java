package com.doacao.emailsender.domain.data;

public class EmailShippingRequest {

    private String user;
    private String message;
    private String subject;
    private String recipient;

    public String getUser() {
        return user;
    }    

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public String getRecipient() {
        return recipient;
    }
}
