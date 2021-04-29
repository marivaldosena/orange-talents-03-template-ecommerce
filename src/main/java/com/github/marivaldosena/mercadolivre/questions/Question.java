package com.github.marivaldosena.mercadolivre.questions;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.products.Product;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_question_user_id"))
    private User author;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_question_product_id"))
    private Product product;

    /**
     * @deprecated Hibernate only.
     */
    public Question() {
    }

    public Question(String title, User author, Product product) {
        this.title = title;
        this.author = author;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public Product getProduct() {
        return product;
    }
}
