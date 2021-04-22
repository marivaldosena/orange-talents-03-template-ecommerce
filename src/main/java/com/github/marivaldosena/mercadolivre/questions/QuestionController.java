package com.github.marivaldosena.mercadolivre.questions;

import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(QuestionController.RESOURCE_URL)
public class QuestionController {
    static final String RESOURCE_URL = "/api/v1/products/{productId}/questions";

    @PostMapping
    @Transactional
    public ResponseEntity<?> askAboutASpecifiProduct(
            @RequestBody @Valid AskAboutProductRequest request,
            @PathVariable UUID productId,
            @AuthenticationPrincipal UserCredentials userCredentials) {
        return ResponseEntity.ok(List.of(request.getQuestion(), productId, userCredentials.getUsername()));
    }
}
