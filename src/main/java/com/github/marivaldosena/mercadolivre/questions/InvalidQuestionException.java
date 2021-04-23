package com.github.marivaldosena.mercadolivre.questions;

import com.github.marivaldosena.mercadolivre.errors.CustomErrorException;

public class InvalidQuestionException extends CustomErrorException {
    public InvalidQuestionException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        return "invalid-question";
    }
}
