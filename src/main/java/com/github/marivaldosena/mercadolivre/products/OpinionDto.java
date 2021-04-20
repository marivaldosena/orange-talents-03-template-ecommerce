package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.opinions.Opinion;

public class OpinionDto {
    private String title;
    private Integer review;
    private String description;

    public OpinionDto(Opinion opinion) {
        this.title = opinion.getTitle();
        this.review = opinion.getReview();
        this.description = opinion.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public Integer getReview() {
        return review;
    }

    public String getDescription() {
        return description;
    }
}
