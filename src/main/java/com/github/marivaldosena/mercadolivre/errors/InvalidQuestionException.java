package com.github.marivaldosena.mercadolivre.errors;

public class InvalidQuestionException extends CustomErrorException {
    public InvalidQuestionException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "invalid-question";
    }
}
