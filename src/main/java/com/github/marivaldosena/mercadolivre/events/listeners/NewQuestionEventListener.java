package com.github.marivaldosena.mercadolivre.events.listeners;

import com.github.marivaldosena.mercadolivre.emails.GenericEmailSender;
import com.github.marivaldosena.mercadolivre.events.NewQuestionEvent;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.questions.Question;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NewQuestionEventListener implements ApplicationListener<NewQuestionEvent> {
    private final GenericEmailSender emailSender;

    public NewQuestionEventListener(GenericEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void onApplicationEvent(NewQuestionEvent event) {
        Question question = event.getQuestion();
        Product product = question.getProduct();

        emailSender.sendEmail(product.getUser(),
                "Question for " + product.getName(),
                question.getTitle(),
                question.getAuthor());
    }
}
