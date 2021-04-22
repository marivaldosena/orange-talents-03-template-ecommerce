package com.github.marivaldosena.mercadolivre.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.products.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AskAboutProductRequest {
    @NotNull
    @NotEmpty
    private String question;

    @JsonCreator
    public AskAboutProductRequest(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public Question toEntity(User user, Product product) {
        return new Question(question, user, product);
    }
}
