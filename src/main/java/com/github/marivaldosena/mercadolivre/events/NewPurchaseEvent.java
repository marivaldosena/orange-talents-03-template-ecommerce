package com.github.marivaldosena.mercadolivre.events;

import com.github.marivaldosena.mercadolivre.purchases.Purchase;
import org.springframework.context.ApplicationEvent;

public class NewPurchaseEvent extends ApplicationEvent {
    private final Purchase purchase;

    public NewPurchaseEvent(Object source, Purchase purchase) {
        super(source);
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
