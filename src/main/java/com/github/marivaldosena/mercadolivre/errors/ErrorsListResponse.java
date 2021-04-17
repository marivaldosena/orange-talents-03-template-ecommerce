package com.github.marivaldosena.mercadolivre.errors;

import java.util.Collections;
import java.util.List;

public class ErrorsListResponse {
    private List<ErrorDto> errors;

    public ErrorsListResponse(List<ErrorDto> errors) {
        this.errors = errors;
    }

    public List<ErrorDto> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
