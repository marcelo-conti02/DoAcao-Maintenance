package com.doacao.emailsender.domain.data;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EmailSender {

    private final Properties properties;
    private final Session session;
    private String user;
    private String password;

    public EmailSender(final String user, final String password) {
        this.properties = new Properties();
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        this.user = user;
        this.password = password;
        this.session =  Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }

    public Properties getProperties() {
        return properties;
    }

    public Session getSession() {
        return session;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUser(final String user) {
        this.user = user;
    }
}
