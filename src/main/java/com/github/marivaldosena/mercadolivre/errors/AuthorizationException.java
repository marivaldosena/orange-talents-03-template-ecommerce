package com.github.marivaldosena.mercadolivre.errors;

public class AuthorizationException extends CustomErrorException {
    public AuthorizationException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "not-authorized";
    }
}
