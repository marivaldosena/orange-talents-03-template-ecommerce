package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.constraints.Exists;
import com.github.marivaldosena.mercadolivre.products.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PurchaseItem {
    @NotNull
    @NotEmpty
    @Exists(entity = Product.class, fields = {"name", "id"})
    private String product;

    @NotNull
    @Min(1)
    private Integer quantity;

    public PurchaseItem(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
