package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.constraints.Exists;
import com.github.marivaldosena.mercadolivre.errors.InvalidOwnershipException;
import com.github.marivaldosena.mercadolivre.errors.ProductNotFoundException;
import com.github.marivaldosena.mercadolivre.errors.UnavailableStockException;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class PurchaseItemRequest {
    @NotNull
    @NotEmpty
    @Exists(entity = Product.class, fields = {"name", "id"})
    private String product;

    @NotNull
    @Min(1)
    private Integer quantity;

    public PurchaseItemRequest(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PurchaseItem toEntity(User currentUser, Purchase purchase, ProductRepository productRepository) {
        Optional<Product> existingProduct = productRepository.findProductByIdOrName(product);

        // Check if product is valid
        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product " + product + " not found");
        }

        // If current user is the product's owner, then he can't buy a product he already has.
        if (existingProduct.get().isCurrentUserTheOwner(currentUser)) {
            throw new InvalidOwnershipException("You cannot purchase a product you already has!");
        }

        // Check product availability, that is, if stock is enough for this request
        if (!existingProduct.get().isStockAvailableFor(quantity)) {
            throw new UnavailableStockException("Stock unavailable for " + existingProduct.get().getName());
        }

        existingProduct.get().depleteStockBy(quantity);

        return new PurchaseItem(existingProduct.get(), quantity, purchase);
    }
}
