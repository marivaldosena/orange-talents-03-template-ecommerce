package com.github.marivaldosena.mercadolivre.purchases.gateway;

import com.github.marivaldosena.mercadolivre.purchases.Purchase;

import java.net.URI;

public class PagseguroGateway implements PaymentGateway {
    private Purchase purchase;
    private String postPaymentUrl;

    public PagseguroGateway(Purchase purchase, String postPaymentUrl) {
        this.purchase = purchase;
        this.postPaymentUrl = postPaymentUrl;
    }

    @Override
    public URI getUri() {
        String urlString = "https://pagseguro.com?returnId=" + purchase.getId() +  "&redirectUrl=" + postPaymentUrl;
        return URI.create(urlString);
    }
}
