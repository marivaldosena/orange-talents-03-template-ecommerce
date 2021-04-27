package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.auth.UserCredentials;
import com.github.marivaldosena.mercadolivre.errors.InvalidOwnershipException;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.products.ProductNotFoundException;
import com.github.marivaldosena.mercadolivre.products.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(PurchaseController.RESOURCE_URL)
public class PurchaseController {
    static final String RESOURCE_URL = "/api/v1/purchases";

    private ProductRepository productRepository;

    public PurchaseController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> purchaseProducts(@RequestBody @Valid PurchaseRequest request, @AuthenticationPrincipal UserCredentials userCredentials) {
        List<Product> products = findProductsFromRequest(request);
        User currentUser = userCredentials.toEntity();

        products.forEach(product -> {
            // If current user is the product's owner, then he can't buy a product he already has.
            if (product.isCurrentUserTheOwner(currentUser)) {
                throw new InvalidOwnershipException("You cannot purchase a product you already has!");
            }
        });

        return ResponseEntity.ok(request);
    }

    private List<Product> findProductsFromRequest(PurchaseRequest request) {

        List<Product> productsList = new ArrayList<>();

        request.getProducts().forEach(item -> {
            Product product = getProductByIdOrName(item.getProduct());
            productsList.add(product);
        });

        return productsList;
    }

    private Product getProductByIdOrName(String idOrName) {
        Optional<Product> existingProduct = productRepository.findProductByIdOrName(idOrName);

        if (!existingProduct.isPresent()) {
            throw new ProductNotFoundException("Product " + idOrName + " not found");
        }

        return existingProduct.get();
    }
}
