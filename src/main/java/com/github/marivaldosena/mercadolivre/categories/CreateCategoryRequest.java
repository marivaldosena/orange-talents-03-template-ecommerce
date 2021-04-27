package com.github.marivaldosena.mercadolivre.categories;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.marivaldosena.mercadolivre.constraints.Exists;
import com.github.marivaldosena.mercadolivre.constraints.Unique;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateCategoryRequest {
    @NotNull
    @NotEmpty
    @Unique(entity = Category.class, field = "name")
    private String category;

    @Exists(entity = Category.class, fields = {"name"}, required = false)
    private String parentCategory;

    @JsonCreator
    public CreateCategoryRequest(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public Category toEntity() {
        return new Category(category);
    }
}
