package com.github.marivaldosena.mercadolivre.questions;

import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.errors.InvalidOwnershipException;
import com.github.marivaldosena.mercadolivre.errors.InvalidQuestionException;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.errors.ProductNotFoundException;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(QuestionController.RESOURCE_URL)
public class QuestionController {
    static final String RESOURCE_URL = "/api/v1/products/{productId}/questions";
    private final QuestionRepository questionRepository;
    private final ProductRepository productRepository;

    public QuestionController(QuestionRepository questionRepository, ProductRepository productRepository) {
        this.questionRepository = questionRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<QuestionDto> askAboutASpecifiProduct(
            @RequestBody @Valid AskAboutProductRequest request,
            @PathVariable UUID productId,
            @AuthenticationPrincipal UserCredentials userCredentials,
            UriComponentsBuilder uriBuilder) {
        Optional<Product> existingProduct = productRepository.findById(productId);

        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        Question question = request.toEntity(userCredentials.toEntity(), existingProduct.get());

        if (!isQuestionValid(question, userCredentials)) {
            throw new InvalidQuestionException("A similar question was already asked by the user for this product");
        }

        if (existingProduct.get().isCurrentUserTheOwner(userCredentials.toEntity())) {
            throw new InvalidOwnershipException("Product's author cannot ask about one's own product");
        }

        questionRepository.save(question);
        URI uri = uriBuilder.path(RESOURCE_URL + "/{questionId}").buildAndExpand(productId, question.getId()).toUri();

        return ResponseEntity.ok().location(uri).body(new QuestionDto(question));
    }

    private boolean isQuestionValid(Question question, UserCredentials currentUser) {
        List<Question> found = questionRepository.findSimilarQuestions(question.getTitle(),
                question.getAuthor().getId(),
                question.getProduct().getId());

        if (found.size() < 1) {
            return true;
        }

        return false;
    }
}
