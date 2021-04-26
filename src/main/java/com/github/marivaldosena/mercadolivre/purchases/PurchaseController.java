package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(PurchaseController.RESOURCE_URL)
public class PurchaseController {
    static final String RESOURCE_URL = "/api/v1/purchases";

    @PostMapping
    @Transactional
    public ResponseEntity<?> purchaseProducts(@RequestBody @Valid PurchaseRequest request, @AuthenticationPrincipal UserCredentials userCredentials) {
        return ResponseEntity.ok(request);
    }
}
