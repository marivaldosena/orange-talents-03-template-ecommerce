package com.github.marivaldosena.mercadolivre.events.listeners;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.emails.GenericEmailSender;
import com.github.marivaldosena.mercadolivre.events.NewPurchaseEvent;
import com.github.marivaldosena.mercadolivre.purchases.Purchase;
import com.github.marivaldosena.mercadolivre.purchases.PurchaseItem;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class NewPurchaseEventListener implements ApplicationListener<NewPurchaseEvent> {
    private final GenericEmailSender emailSender;

    public NewPurchaseEventListener(GenericEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void onApplicationEvent(NewPurchaseEvent event) {
        Purchase purchase = event.getPurchase();
        User buyer = purchase.getBuyer();
        Map<User, List<PurchaseItem>> usersWithPurchaseItems = getRecipientsWithCorrespondingPurchaseItems(purchase);

        usersWithPurchaseItems.forEach((recipient, items) -> {
            emailSender.sendEmail(recipient,
                    "New Purchase " + purchase.getId(),
                    getEmailBodyMessageFrom(items),
                    buyer);
        });
    }

    private Map<User, List<PurchaseItem>> getRecipientsWithCorrespondingPurchaseItems(Purchase purchase) {
        Map<User, List<PurchaseItem>> usersWithItems = new HashMap<>();
        Set<User> users = new HashSet<>(
                purchase.getItems().stream()
                .map(item -> item.getSeller())
                .collect(Collectors.toSet()));

        users.forEach(user -> {
            usersWithItems.put(user, purchase.getItems().stream()
                    .filter(item -> item.getSeller().getEmail().compareTo(user.getEmail()) == 0)
                    .collect(Collectors.toList()));
        });

        return usersWithItems;
    }
    
    private String getEmailBodyMessageFrom(List<PurchaseItem> items) {
        StringBuffer sb = new StringBuffer();

        sb.append("\n************************** Items ***************************\n");
        items.forEach(item -> {
            sb.append("------------------------------------------------------------\n");
            sb.append("Item: " + item.getProductName() + "\n");
            sb.append("Price: " + item.getPaidPrice() + "\n");
            sb.append("Quantity: " + item.getQuantity() + "\n");
            sb.append("------------------------------------------------------------\n");
        });
        sb.append("************************************************************\n");

        return sb.toString();
    }
}
