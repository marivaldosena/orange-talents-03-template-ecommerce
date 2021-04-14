package com.github.marivaldosena.mercadolivre.auth;

import com.github.marivaldosena.mercadolivre.constraints.Unique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationRequest {
    @NotNull
    @NotEmpty
    @Email
    @Unique(entity = User.class, field = "email")
    private String email;

    @NotNull
    @Size(min = 6, max = 256)
    private String password;

    /**
     *
     * @param email User's e-mail.
     * @param password Login password.
     */
    public RegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User toEntity() {
        return new User(email, password);
    }
}
