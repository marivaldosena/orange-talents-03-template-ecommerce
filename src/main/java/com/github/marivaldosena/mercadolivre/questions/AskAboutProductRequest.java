package com.github.marivaldosena.mercadolivre.questions;

import com.fasterxml.jackson.annotation.JsonCreator;

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
}
