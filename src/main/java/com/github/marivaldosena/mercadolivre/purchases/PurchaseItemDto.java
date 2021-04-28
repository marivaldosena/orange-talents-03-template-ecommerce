package com.github.marivaldosena.mercadolivre.purchases;

import java.math.BigDecimal;

public class PurchaseItemDto {
    private String product;
    private Integer quantity;
    private BigDecimal price;

    public PurchaseItemDto(PurchaseItem item) {
        this.product = item.getProductName();
        this.quantity = item.getQuantity();
        this.price = item.getPaidPrice();
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSubtotal() {
        return price.multiply(new BigDecimal(quantity));
    }
}
