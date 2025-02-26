package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.categories.Category;
import com.github.marivaldosena.mercadolivre.categories.CategoryRepository;
import com.github.marivaldosena.mercadolivre.errors.ProductNotFoundException;
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
@RequestMapping(ProductController.RESOURCE_URL)
public class ProductController {
    public final static String RESOURCE_URL = "/api/v1/products";
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductWithFullDetailsDto> getDetailsFor(@PathVariable("id") UUID productId) {
        Optional<Product> existingProduct = productRepository.findById(productId);

        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        return ResponseEntity.ok(new ProductWithFullDetailsDto(existingProduct.get()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createProduct(@RequestBody @Valid CreateProductRequest request, UriComponentsBuilder uriBuilder, @AuthenticationPrincipal UserCredentials userCredentials) {
        Category category = categoryRepository.findByName(request.getCategory()).get();
        Product product = request.toEntity();
        product.setCategory(category);
        product.setUser(userCredentials.toEntity());
        product = productRepository.save(product);
        URI uri = uriBuilder.path(RESOURCE_URL + "/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.ok().location(uri).body(new ProductDto(product));
    }
}
