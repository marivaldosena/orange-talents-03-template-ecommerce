package com.github.marivaldosena.mercadolivre.opinions;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.products.ProductNotFoundException;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(OpinionController.RESOURCE_URL)
public class OpinionController {
    public final static String RESOURCE_URL = "/api/v1/products/{id}/opinions";

    private ProductRepository productRepository;

    public OpinionController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> addOpinionToProduct(
            @RequestBody @Valid AddOpinionRequest request,
            @PathVariable("id") UUID productId,
            @AuthenticationPrincipal UserCredentials userCredentials) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        User authenticatedUser = userCredentials.toEntity();

        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        return ResponseEntity.ok(request);
    }
}
