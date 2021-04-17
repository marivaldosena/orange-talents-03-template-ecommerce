package com.github.marivaldosena.mercadolivre.products;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class ProductDetailRequest {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @Size(min = 3, max = 1000)
    private String description;

    public ProductDetailRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetailRequest that = (ProductDetailRequest) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Characteristic toEntity() {
        return new Characteristic(name, description);
    }
}
