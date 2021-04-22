package com.github.marivaldosena.mercadolivre.questions;

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
@RequestMapping(QuestionController.RESOURCE_URL)
public class QuestionController {
    static final String RESOURCE_URL = "/api/v1/products/{productId}/questions";
    private QuestionRepository questionRepository;
    private ProductRepository productRepository;

    public QuestionController(QuestionRepository questionRepository, ProductRepository productRepository) {
        this.questionRepository = questionRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<QuestionDto> askAboutASpecifiProduct(
            @RequestBody @Valid AskAboutProductRequest request,
            @PathVariable UUID productId,
            @AuthenticationPrincipal UserCredentials userCredentials) {
        Optional<Product> existingProduct = productRepository.findById(productId);

        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        Question question = request.toEntity(userCredentials.toEntity(), existingProduct.get());
        questionRepository.save(question);

        return ResponseEntity.ok(new QuestionDto(question));
    }
}
