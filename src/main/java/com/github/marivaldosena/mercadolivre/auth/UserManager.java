package com.github.marivaldosena.mercadolivre.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserManager implements UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(username));

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Invalid credentials");
        }

        return new UserCredentials(user.get());
    }

    public boolean isTokenValid(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public User getUserByToken(String token) {
        if (!isTokenValid(token)) {
            return null;
        }

        Claims claims = getClaimsFromToken(token).getBody();
        User user = userRepository.findByEmail(claims.getSubject());

        return user;
    }

    private Jws<Claims> getClaimsFromToken(String token) {
        // This method may throw Exceptions, that's why we must check token validation first.
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
