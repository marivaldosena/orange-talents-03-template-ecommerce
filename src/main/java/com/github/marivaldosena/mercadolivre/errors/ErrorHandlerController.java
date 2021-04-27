package com.github.marivaldosena.mercadolivre.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandlerController {
    private MessageSource messageSource;

    @Autowired
    public ErrorHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorsListResponse handle(HttpMessageNotReadableException exception) {
        List<ErrorDto> errors = new ArrayList<>();
        errors.add(new ErrorDto("json", "Malformed JSON"));
        return new ErrorsListResponse(errors);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorsListResponse handle(MethodArgumentNotValidException exception) {
        List<ErrorDto> errors = new ArrayList<>();

        List<FieldError> fieldsErrors = exception.getBindingResult().getFieldErrors();
        fieldsErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            errors.add(new ErrorDto(e.getField(), message));
        });

        return new ErrorsListResponse(errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomErrorException.class)
    public ErrorsListResponse handle(CustomErrorException exception) {
        ErrorDto error = new ErrorDto(exception.getErrorCode(), exception.getMessage());
        return new ErrorsListResponse(List.of(error));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ItemNotFoundException.class)
    public ErrorsListResponse handle(ItemNotFoundException exception) {
        ErrorDto error = new ErrorDto(exception.getErrorCode(), exception.getMessage());
        return new ErrorsListResponse(List.of(error));
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public ErrorsListResponse handle(AuthorizationException exception) {
        ErrorDto error = new ErrorDto(exception.getErrorCode(), exception.getMessage());
        return new ErrorsListResponse(List.of(error));
    }
}
