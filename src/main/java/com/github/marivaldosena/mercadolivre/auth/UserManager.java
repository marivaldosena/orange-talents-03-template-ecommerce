package com.github.marivaldosena.mercadolivre.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserManager {
    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration}")
    private String expiration;

    @Autowired
    private UserRepository userRepository;

    public String generateToken(User user) {
        Date now = new Date();
        Date tokenExpireAt = new Date(now.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Mercado Livre")
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .setExpiration(tokenExpireAt)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public boolean checkPassword(User user, String password) {
        return user != null && new BCryptPasswordEncoder().matches(password, user.getPassword());
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
