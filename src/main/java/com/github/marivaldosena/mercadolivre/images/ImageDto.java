package com.github.marivaldosena.mercadolivre.images;

public class ImageDto {
    private String image;
    private Long size;

    public ImageDto(ProductImage productImage) {
        this.image = productImage.getName();
        this.size = productImage.getSize();
    }

    public String getImage() {
        return image;
    }

    public Long getSize() {
        return size;
    }
}
