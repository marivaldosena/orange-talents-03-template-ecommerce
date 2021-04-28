package com.github.marivaldosena.mercadolivre.auth;

import com.github.marivaldosena.mercadolivre.opinions.Opinion;
import com.github.marivaldosena.mercadolivre.products.Product;
import com.github.marivaldosena.mercadolivre.purchases.Purchase;
import com.github.marivaldosena.mercadolivre.purchases.PurchaseItem;
import com.github.marivaldosena.mercadolivre.questions.Question;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Product> products;

    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)
    private List<Opinion> opinions;

    @OneToMany(mappedBy = "author", cascade = CascadeType.MERGE)
    private List<Question> questions;

    @OneToMany(mappedBy = "buyer")
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "seller")
    private List<PurchaseItem> soldItems;

    @Transient
    private UserManager userManager;

    /**
     * @deprecated Hibernate only.
     */
    public User() {
    }

    /**
     *  @param email User's e-mail.
     * @param password Login password.
     */
    public User(String email, String password) {
        this.userManager = new UserManager();
        this.email = email;
        this.password = this.userManager.hashPassword(password);
        this.opinions = new ArrayList<>();
        this.products = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.purchases = new ArrayList<>();
        this.soldItems = new ArrayList<>();
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
        return Collections.unmodifiableList(products);
    }

    public List<Opinion> getOpinions() {
        return Collections.unmodifiableList(opinions);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public List<Purchase> getPurchases() {
        return Collections.unmodifiableList(purchases);
    }

    public List<PurchaseItem> getSoldItems() {
        return Collections.unmodifiableList(soldItems);
    }

    public void setNewPassword(String password) {
        this.password = userManager.hashPassword(password);
    }
}
