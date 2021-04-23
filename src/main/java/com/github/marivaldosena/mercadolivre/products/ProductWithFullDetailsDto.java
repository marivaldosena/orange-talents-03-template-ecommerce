package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.images.ImageDto;
import com.github.marivaldosena.mercadolivre.opinions.OpinionDto;
import com.github.marivaldosena.mercadolivre.questions.QuestionDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductWithFullDetailsDto {
    private String product;
    private BigDecimal price;
    private String description;
    private Set<ImageDto> images;
    private Set<ProductDetailDto> characteristics;
    private Double averageReview;
    private Long numberOfReviews;
    private List<OpinionDto> opinions;
    private List<QuestionDto> questions;

    public ProductWithFullDetailsDto(Product product) {
        this.product = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.images = product.getImages().stream().map(ImageDto::new).collect(Collectors.toSet());
        this.characteristics = product.getDetails().stream().map(ProductDetailDto::new).collect(Collectors.toSet());
        this.opinions = product.getOpinions().stream().map(OpinionDto::new).collect(Collectors.toList());
        this.averageReview = product.getOpinions().stream().mapToDouble(o -> o.getReview()).average().getAsDouble();
        this.numberOfReviews = product.getOpinions().stream().mapToInt(o -> o.getReview()).count();
        this.questions = product.getQuestions().stream().map(QuestionDto::new).collect(Collectors.toList());
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Set<ImageDto> getImages() {
        return Collections.unmodifiableSet(images);
    }

    public Set<ProductDetailDto> getCharacteristics() {
        return Collections.unmodifiableSet(characteristics);
    }

    public Double getAverageReview() {
        return averageReview;
    }

    public Long getNumberOfReviews() {
        return numberOfReviews;
    }

    public List<OpinionDto> getOpinions() {
        return Collections.unmodifiableList(opinions);
    }

    public List<QuestionDto> getQuestions() {
        return Collections.unmodifiableList(questions);
    }
}
