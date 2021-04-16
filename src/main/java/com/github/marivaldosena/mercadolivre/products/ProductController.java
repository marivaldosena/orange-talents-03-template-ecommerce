package com.github.marivaldosena.mercadolivre.products;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(ProductController.RESOURCE_URL)
public class ProductController {
    public final static String RESOURCE_URL = "/api/v1/products";

    @PostMapping
    @Transactional
    public ResponseEntity<?> createProduct(@RequestBody @Valid CreateProductRequest request) {
        return ResponseEntity.ok(request);
    }
}
