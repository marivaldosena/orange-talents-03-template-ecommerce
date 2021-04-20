package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.images.ImageDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;
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
    private List<OpinionDto> opinions;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.product = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.details = product.getDetails().stream().map(ProductDetailDto::new).collect(Collectors.toList());
        this.category = product.getCategory().getName();
        this.images = product.getImages().stream().map(ImageDto::new).collect(Collectors.toSet());
        this.opinions = product.getOpinions().stream().map(OpinionDto::new).collect(Collectors.toList());
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

    public List<OpinionDto> getOpinions() {
        return Collections.unmodifiableList(opinions);
    }

    public Set<ImageDto> getImages() {
        return Collections.unmodifiableSet(images);
    }
}
