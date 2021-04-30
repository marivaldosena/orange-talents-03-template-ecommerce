package com.github.marivaldosena.mercadolivre.purchases.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "payment-client", url = "http://localhost:8080")
public interface PaymentHttpClient {
    @PostMapping(value = PaymentController.RESOURCE_URL, consumes = "application/json")
    String getPayment(PaymentGateway paymentGateway);
}
