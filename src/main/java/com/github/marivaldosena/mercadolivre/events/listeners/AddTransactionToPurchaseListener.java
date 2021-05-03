package com.github.marivaldosena.mercadolivre.events.listeners;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.emails.GenericEmailSender;
import com.github.marivaldosena.mercadolivre.events.AddTransactionToPurchaseEvent;
import com.github.marivaldosena.mercadolivre.purchases.Purchase;
import com.github.marivaldosena.mercadolivre.purchases.PurchaseRepository;
import org.springframework.context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AddTransactionToPurchaseListener implements ApplicationListener<AddTransactionToPurchaseEvent> {
    private final GenericEmailSender emailSender;

    public AddTransactionToPurchaseListener(GenericEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void onApplicationEvent(AddTransactionToPurchaseEvent event) {
        Purchase purchase = event.getPurchase();
        String transactionId = event.getInvoiceId();
        PurchaseRepository repository = event.getRepository();

        /* TODO: Should validate data. */
        purchase.setTransaction(transactionId);
        repository.save(purchase);

        Set<User> sellers = new HashSet<>(purchase.getItems().stream()
                        .map(item -> item.getSeller())
                        .collect(Collectors.toSet()));

        sellers.forEach(seller -> {
            emailSender.sendEmail(seller,
                    "Payment for Purchase " + purchase.getId(),
                    "Payment for purchase " + purchase.getId() + " was approved by " + purchase.getGatewayType(),
                    purchase.getBuyer());
        });
    }
}
