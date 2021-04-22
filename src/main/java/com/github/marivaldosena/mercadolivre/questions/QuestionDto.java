package com.github.marivaldosena.mercadolivre.questions;

public class QuestionDto {
    private String product;
    private String question;
    private String user;

    public QuestionDto(Question question) {
        this.product = question.getProduct().getName();
        this.question = question.getTitle();
        this.user = question.getAuthor().getEmail();
    }

    public String getProduct() {
        return product;
    }

    public String getQuestion() {
        return question;
    }

    public String getUser() {
        return user;
    }
}
