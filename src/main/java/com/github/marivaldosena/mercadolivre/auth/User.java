package com.github.marivaldosena.mercadolivre.auth;

import com.github.marivaldosena.mercadolivre.products.Product;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="uuid-char")
    @Column(name = "id", updatable = false, insertable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @Transient
    private UserManager userManager;

    /**
     * @deprecated Hibernate only.
     */
    public User() {
    }

    /**
     *
     * @param email User's e-mail.
     * @param password Login password.
     */
    public User(String email, String password) {
        this.userManager = new UserManager();
        this.email = email;
        this.password = this.userManager.hashPassword(password);
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setNewPassword(String password) {
        this.password = userManager.hashPassword(password);
    }
}
