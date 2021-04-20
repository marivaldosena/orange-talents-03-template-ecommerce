package com.github.marivaldosena.mercadolivre.opinions;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddOpinionRequest {
    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @Range(min = 1, max = 5)
    private Integer review;

    @NotNull
    @Size(min = 3, max = 500)
    private String description;

    public AddOpinionRequest(String title, Integer review, String description) {
        this.title = title;
        this.review = review;
        this.description = description;
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

    public Opinion toEntity() {
        return new Opinion(title, review, description);
    }
}
