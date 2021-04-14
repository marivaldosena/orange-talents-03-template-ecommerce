package com.github.marivaldosena.mercadolivre.auth;

public class AuthDto {
    private String token;

    public AuthDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
