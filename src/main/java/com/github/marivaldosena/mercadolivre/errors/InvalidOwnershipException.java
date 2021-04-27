package com.github.marivaldosena.mercadolivre.errors;

public class InvalidOwnershipException extends AuthorizationException {
    public InvalidOwnershipException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "invalid-ownership";
    }
}
