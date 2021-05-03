package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.events.AddTransactionToPurchaseEvent;
import com.github.marivaldosena.mercadolivre.events.NewPurchaseEvent;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import com.github.marivaldosena.mercadolivre.purchases.gateway.PaymentHttpClient;
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
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(PurchaseController.RESOURCE_URL)
public class PurchaseController {
    static final String RESOURCE_URL = "/api/v1/purchases";

    private PurchaseRepository purchaseRepository;
    private ProductRepository productRepository;
    private PurchaseItemRepository itemsRepository;
    private ApplicationEventPublisher publisher;
    private PaymentHttpClient client;

    public PurchaseController(PurchaseRepository purchaseRepository, ProductRepository productRepository, PurchaseItemRepository itemsRepository, ApplicationEventPublisher publisher, PaymentHttpClient client) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
        this.itemsRepository = itemsRepository;
        this.publisher = publisher;
        this.client = client;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PurchaseDto> purchaseProducts(@RequestBody @Valid PurchaseRequest request,
                                              @AuthenticationPrincipal UserCredentials userCredentials,
                                              UriComponentsBuilder uriBuilder) {
        User currentUser = userCredentials.toEntity();

        Purchase purchase = request.toEntity(currentUser, productRepository);
        purchase = purchaseRepository.save(purchase);
        itemsRepository.saveAll(purchase.getItems());

        publisher.publishEvent(new NewPurchaseEvent(this, purchase));
        URI uri = uriBuilder.path(RESOURCE_URL + "/{id}").buildAndExpand(purchase.getId()).toUri();

        /**
         * TODO: Implement Observer (Publisher/Subscriber) Pattern for all these tasks below.
         */
        doPaymentGatewayRequest(client, purchase);
        getRanking();
        publisher.publishEvent(new AddTransactionToPurchaseEvent(this, purchase, getInvoiceId(purchase), purchaseRepository));

        return ResponseEntity.ok().location(uri).body(new PurchaseDto(purchase));
    }

    private void doPaymentGatewayRequest(PaymentHttpClient client, Purchase purchase) {
        System.out.println("============================================");
        System.out.println("FEIGN");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println(client.getPayment(purchase.getPaymentGateway()));
        System.out.println("============================================");
    }

    private void getRanking() {
        System.out.println("============================================");
        System.out.println("RANKING");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Ranking: " + (new Random().nextInt(1000) + 1));
        System.out.println("============================================");
    }

    /**
     * It should simulate a request for gateway service to obtain transactionId.
     * @param purchase
     */
    private String getInvoiceId(Purchase purchase) {
        String result = "Invoice: " + UUID.randomUUID() + "\nPurchase: " + purchase.getId();
        System.out.println("============================================");
        System.out.println("INVOICE");
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println(result);
        System.out.println("============================================");
        return result;
    }
}
