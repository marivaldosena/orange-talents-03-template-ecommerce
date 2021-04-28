package com.github.marivaldosena.mercadolivre.purchases;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PurchaseDto {
    private UUID id;
    private String gateway;
    private List<PurchaseItemDto> items;

    public PurchaseDto(Purchase purchase) {
        this.id = purchase.getId();
        this.gateway = purchase.getGateway().toString();
        this.items = purchase.getItems().stream()
                .map(PurchaseItemDto::new)
                .collect(Collectors.toList());
    }

    public UUID getId() {
        return id;
    }

    public String getGateway() {
        return gateway;
    }

    public List<PurchaseItemDto> getItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(item -> item.getSubtotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
