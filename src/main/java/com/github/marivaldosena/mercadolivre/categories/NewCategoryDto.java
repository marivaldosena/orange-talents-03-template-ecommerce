package com.github.marivaldosena.mercadolivre.categories;

import java.util.Optional;

public class NewCategoryDto {
    private String category;
    private Optional<Category> parentCategory;

    public NewCategoryDto(Category entity) {
        this.category = entity.getName();
        this.parentCategory = Optional.ofNullable(entity.getParent());
    }

    public String getCategory() {
        return category;
    }

    public String getParentCategory() {
        if (!parentCategory.isPresent()) {
            return null;
        }

        return parentCategory.get().getName();
    }
}
