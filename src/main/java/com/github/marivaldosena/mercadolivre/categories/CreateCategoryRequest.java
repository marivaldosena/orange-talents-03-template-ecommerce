package com.github.marivaldosena.mercadolivre.categories;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateCategoryRequest {
    @NotNull
    @NotEmpty
    @JsonProperty("category")
    private String category;

    @JsonCreator
    public CreateCategoryRequest(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
