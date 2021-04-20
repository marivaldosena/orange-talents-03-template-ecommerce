package com.github.marivaldosena.mercadolivre.opinions;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.products.ProductDto;
import com.github.marivaldosena.mercadolivre.products.ProductNotFoundException;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(OpinionController.RESOURCE_URL)
public class OpinionController {
    public final static String RESOURCE_URL = "/api/v1/products/{productId}/opinions";

    private OpinionRepository opinionRepository;
    private ProductRepository productRepository;

    public OpinionController(OpinionRepository opinionRepository, ProductRepository productRepository) {
        this.opinionRepository = opinionRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDto> addOpinionToProduct(
            @RequestBody @Valid AddOpinionRequest request,
            @PathVariable UUID productId,
            @AuthenticationPrincipal UserCredentials userCredentials,
            UriComponentsBuilder uriBuilder) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        User authenticatedUser = userCredentials.toEntity();

        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        Opinion newOpinion = request.toEntity();
        newOpinion.setProduct(existingProduct.get());
        newOpinion.setAuthor(authenticatedUser);
        opinionRepository.save(newOpinion);
        productRepository.save(existingProduct.get());

        URI uri = uriBuilder.path(RESOURCE_URL + "/{opinionId}").buildAndExpand(productId, newOpinion.getId()).toUri();

        return ResponseEntity.ok().location(uri).body(new ProductDto(existingProduct.get()));
    }
}
