package com.github.marivaldosena.mercadolivre.products;

public class ProductDetailDto {
    private String detail;
    private String description;

    public ProductDetailDto(Characteristic characteristic) {
        this.detail = characteristic.getName();
        this.description = characteristic.getDescription();
    }

    public String getDetail() {
        return detail;
    }

    public String getDescription() {
        return description;
    }
}
