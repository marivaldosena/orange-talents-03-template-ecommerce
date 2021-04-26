package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.categories.Category;
import com.github.marivaldosena.mercadolivre.constraints.Exists;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateProductRequest {
    @NotNull
    @NotEmpty
    private String product;

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer quantity;

    @NotNull
    @Size(min = 3, max = 1000)
    private String description;

    @Valid
    @NotNull
    @Size(min = 3)
    @UniqueElements
    private Set<ProductDetailRequest> characteristics;

    @NotNull
    @Exists(entity = Category.class, fields = {"name"})
    private String category;

    public CreateProductRequest(String product, BigDecimal price, Integer quantity, String description, String category) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.characteristics = new HashSet<>();
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Set<ProductDetailRequest> getCharacteristics() {
        return Collections.unmodifiableSet(characteristics);
    }

    public String getCategory() {
        return category;
    }

    public void setCharacteristics(Set<ProductDetailRequest> characteristics) {
        this.characteristics = characteristics;
    }

    public Product toEntity() {
        Set<Characteristic> productDetails = this.getCharacteristics().stream().map(ProductDetailRequest::toEntity).collect(Collectors.toSet());
        Product entity = new Product(product, price, quantity, description);
        entity.setDetails(productDetails);

        return entity;
    }
}
