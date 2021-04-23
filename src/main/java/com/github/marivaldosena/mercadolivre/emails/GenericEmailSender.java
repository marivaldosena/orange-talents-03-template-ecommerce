package com.github.marivaldosena.mercadolivre.emails;

import com.github.marivaldosena.mercadolivre.auth.User;

public interface GenericEmailSender {
    void sendEmail(User recipient, String title, String message, User sender);
}
