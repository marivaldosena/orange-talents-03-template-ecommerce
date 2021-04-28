package com.github.marivaldosena.mercadolivre.errors;

public class ProductNotFoundException extends ItemNotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "product-not-found";
    }
}
