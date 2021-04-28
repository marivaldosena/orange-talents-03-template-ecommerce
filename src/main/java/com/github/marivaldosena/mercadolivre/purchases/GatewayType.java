package com.github.marivaldosena.mercadolivre.purchases;

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
