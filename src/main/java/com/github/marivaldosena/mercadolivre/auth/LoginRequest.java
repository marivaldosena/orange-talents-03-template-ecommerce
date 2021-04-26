package com.github.marivaldosena.mercadolivre.auth;

import com.github.marivaldosena.mercadolivre.constraints.Exists;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequest {
    @NotNull
    @NotEmpty
    @Email
    @Exists(entity = User.class, fields = {"email"})
    private String email;

    @NotNull
    @Size(min = 6, max = 120)
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User toEntity(UserManager userManager) {
        UserCredentials credentials = (UserCredentials) userManager.loadUserByUsername(email);
        User user = credentials.toEntity();

        if (!userManager.checkPassword(user, password)) {
            throw new UsernameNotFoundException("Invalid credentials");
        }

        return user;
    }
}
