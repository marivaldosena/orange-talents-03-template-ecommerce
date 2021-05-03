package com.github.marivaldosena.mercadolivre.events;

import com.github.marivaldosena.mercadolivre.purchases.Purchase;
import com.github.marivaldosena.mercadolivre.purchases.PurchaseController;
import com.github.marivaldosena.mercadolivre.purchases.PurchaseRepository;
import org.springframework.context.ApplicationEvent;

public class AddTransactionToPurchaseEvent extends ApplicationEvent {
    private final Purchase purchase;
    private final String invoiceId;
    private final PurchaseRepository repository;

    public AddTransactionToPurchaseEvent(PurchaseController source, Purchase purchase, String invoiceId, PurchaseRepository repository) {
        super(source);
        this.purchase = purchase;
        this.invoiceId = invoiceId;
        this.repository = repository;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public PurchaseRepository getRepository() {
        return repository;
    }
}
