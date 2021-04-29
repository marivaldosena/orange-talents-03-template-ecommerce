package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.events.NewPurchaseEvent;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(PurchaseController.RESOURCE_URL)
public class PurchaseController {
    static final String RESOURCE_URL = "/api/v1/purchases";

    private PurchaseRepository purchaseRepository;
    private ProductRepository productRepository;
    private PurchaseItemRepository itemsRepository;
    private ApplicationEventPublisher publisher;

    public PurchaseController(PurchaseRepository purchaseRepository, ProductRepository productRepository, PurchaseItemRepository itemsRepository, ApplicationEventPublisher publisher) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.itemsRepository = itemsRepository;
        this.publisher = publisher;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PurchaseDto> purchaseProducts(@RequestBody @Valid PurchaseRequest request,
                                              @AuthenticationPrincipal UserCredentials userCredentials,
                                              UriComponentsBuilder uriBuilder) {
        // TODO: Validate sent gateway.
        User currentUser = userCredentials.toEntity();

        Purchase purchase = request.toEntity(currentUser, productRepository);
        purchase = purchaseRepository.save(purchase);
        itemsRepository.saveAll(purchase.getItems());

        publisher.publishEvent(new NewPurchaseEvent(this, purchase));
        URI uri = uriBuilder.path(RESOURCE_URL + "/{id}").buildAndExpand(purchase.getId()).toUri();

        return ResponseEntity.ok().location(uri).body(new PurchaseDto(purchase));
    }
}
