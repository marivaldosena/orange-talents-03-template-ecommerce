package com.github.marivaldosena.mercadolivre.purchases;

import java.net.URI;

public class PaypalGateway implements PaymentGateway {
    private Purchase purchase;
    private String postPaymentUrl;

    public PaypalGateway(Purchase purchase, String postPaymentUrl) {
        this.purchase = purchase;
        this.postPaymentUrl = postPaymentUrl;
    }

    @Override
    public URI getUri() {
        String urlString = "paypal.com?buyerId=" + purchase.getId() + "&redirectUrl=" + postPaymentUrl;
        return URI.create(urlString);
    }
}
