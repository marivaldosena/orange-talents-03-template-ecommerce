package com.github.marivaldosena.mercadolivre.emails;

import com.github.marivaldosena.mercadolivre.auth.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mockConsole")
@Primary
public class MockConsoleEmailSender implements GenericEmailSender {
    @Override
    public void sendEmail(User recipient, String title, String message, User sender) {
        System.out.println("============================================================");
        System.out.println("********************** E-mail Sent *************************");
        System.out.println("============================================================");
        System.out.println("Recipient: " + recipient.getEmail());
        System.out.println("Title: " + title);
        System.out.println("============================================================");
        System.out.println("Message: " + message);
        System.out.println("============================================================");
        System.out.println("Sender: " + sender.getEmail());
        System.out.println("============================================================");
    }
}
