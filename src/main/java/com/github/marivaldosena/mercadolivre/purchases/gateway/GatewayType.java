package com.github.marivaldosena.mercadolivre.purchases.gateway;

import com.github.marivaldosena.mercadolivre.purchases.Purchase;

public enum GatewayType {
    PAYPAL {
        @Override
        public PaymentGateway getGateway(Purchase purchase, String postPaymentUrl) {
            return new PaypalGateway(purchase, postPaymentUrl);
        }
    },
    PAGSEGURO {
        @Override
        public PaymentGateway getGateway(Purchase purchase, String postPaymentUrl) {
            return new PagseguroGateway(purchase, postPaymentUrl);
        }
    };

    public abstract PaymentGateway getGateway(Purchase purchase, String postPaymentUrl);
}
