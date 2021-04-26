package com.github.marivaldosena.mercadolivre.purchases;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PurchaseRequest {
    @NotNull
    @Size(min = 1)
    @Valid
    List<PurchaseItem> products;

    public void setProducts(List<PurchaseItem> products) {
        this.products = products;
    }

    public List<PurchaseItem> getProducts() {
        return products;
    }
}
