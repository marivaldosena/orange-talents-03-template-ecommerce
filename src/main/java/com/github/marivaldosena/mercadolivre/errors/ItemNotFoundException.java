package com.github.marivaldosena.mercadolivre.errors;

public abstract class ItemNotFoundException extends CustomErrorException {
    public ItemNotFoundException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return "not-found";
    };
}
