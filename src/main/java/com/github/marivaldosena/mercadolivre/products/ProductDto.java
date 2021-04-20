package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.images.ImageDto;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDto {
    private UUID id;
    private String product;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private List<ProductDetailDto> details;
    private String category;
    private Set<ImageDto> images;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.product = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.details = product.getDetails().stream().map(ProductDetailDto::new).collect(Collectors.toList());
        this.category = product.getCategory().getName();
        this.images = product.getImages().stream().map(ImageDto::new).collect(Collectors.toSet());
    }

    public UUID getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public List<ProductDetailDto> getDetails() {
        return Collections.unmodifiableList(details);
    }

    public String getCategory() {
        return category;
    }

    public Set<ImageDto> getImages() {
        return Collections.unmodifiableSet(images);
    }
}
