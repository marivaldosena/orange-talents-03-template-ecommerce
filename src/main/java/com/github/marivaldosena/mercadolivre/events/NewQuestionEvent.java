package com.github.marivaldosena.mercadolivre.events;

import com.github.marivaldosena.mercadolivre.questions.Question;
import org.springframework.context.ApplicationEvent;

public class NewQuestionEvent extends ApplicationEvent {
    private final Question question;

    public NewQuestionEvent(Object source, Question question) {
        super(source);
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }
}
