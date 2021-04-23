package com.github.marivaldosena.mercadolivre.errors;

public class CustomErrorException extends RuntimeException {
    public CustomErrorException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return "generic-error";
    };
}
