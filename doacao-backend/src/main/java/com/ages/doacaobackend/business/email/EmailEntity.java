package com.ages.doacaobackend.business.email;

public class EmailEntity {

    private String user;
    private String message;
    private String subject;
    private String recipient;

    public EmailEntity(final String user, final String message, final String subject, final String recipient) {
        this.user = user;
        this.message = message;
        this.subject = subject;
        this.recipient = recipient;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

}