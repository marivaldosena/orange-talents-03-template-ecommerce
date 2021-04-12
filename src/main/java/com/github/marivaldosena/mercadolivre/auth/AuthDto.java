package com.github.marivaldosena.mercadolivre.auth;

public class AuthDto {
    private String token;

    public AuthDto(User user) {
        /**
         * TODO: Implement token generation using JWT.
         */
        this.token = user.getEmail();
    }

    public String getToken() {
        return token;
    }
}
