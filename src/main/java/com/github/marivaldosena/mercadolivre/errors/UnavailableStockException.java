package com.github.marivaldosena.mercadolivre.errors;

public class UnavailableStockException extends CustomErrorException {
    public UnavailableStockException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "unavailable-stock";
    }
}
