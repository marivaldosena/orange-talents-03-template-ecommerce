package com.github.marivaldosena.mercadolivre.categories;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(CategoryController.RESOURCE_URL)
public class CategoryController {
    public final static String RESOURCE_URL = "/api/v1/categories";

    @PostMapping
    @Transactional
    public ResponseEntity<CreateCategoryRequest> createCategory(@RequestBody @Valid CreateCategoryRequest request) {
        return ResponseEntity.ok(request);
    }
}
