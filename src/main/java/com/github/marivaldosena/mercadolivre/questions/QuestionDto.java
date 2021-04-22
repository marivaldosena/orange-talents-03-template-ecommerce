package com.github.marivaldosena.mercadolivre.questions;

public class QuestionDto {
    private String product;
    private String title;
    private String user;

    public QuestionDto(String product, String title, String user) {
        this.product = product;
        this.title = title;
        this.user = user;
    }
}
