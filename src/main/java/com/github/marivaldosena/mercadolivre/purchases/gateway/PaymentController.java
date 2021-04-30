package com.github.marivaldosena.mercadolivre.purchases.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PaymentController.RESOURCE_URL)
public class PaymentController {
    public final static String RESOURCE_URL = "/api/v1/purchases/payment";

    @PostMapping
    public ResponseEntity<?> getPaymentGateway(@RequestBody String gatewayUrl) {
        return ResponseEntity.ok("Gateway validated for " + gatewayUrl);
    }
}
