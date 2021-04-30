package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import com.github.marivaldosena.mercadolivre.purchases.gateway.GatewayType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseRequest {
    @NotNull
    @Size(min = 1)
    @Valid
    private List<PurchaseItemRequest> products;

    @NotNull
    private String gateway;

    public PurchaseRequest(List<PurchaseItemRequest> products, String gateway) {
        this.products = products;
        this.gateway = gateway;
    }

    public List<PurchaseItemRequest> getProducts() {
        return products;
    }

    public String getGateway() {
        return gateway;
    }

    public Purchase toEntity(User buyer, ProductRepository productRepository) {
        Purchase newPurchase = new Purchase(buyer, GatewayType.valueOf(gateway));

        List<PurchaseItem> items = products.stream()
                .map(item -> item.toEntity(buyer, newPurchase, productRepository))
                .collect(Collectors.toList());

        newPurchase.setItems(items);
        return newPurchase;
    }
}
