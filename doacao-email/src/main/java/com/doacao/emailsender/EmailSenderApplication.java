package com.doacao.emailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSenderApplication {

    public static void main(String[] args) {
        System.out.println("To rodando");
        SpringApplication.run(EmailSenderApplication.class, args);
    }

}
