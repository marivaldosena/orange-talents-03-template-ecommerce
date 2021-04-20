package com.github.marivaldosena.mercadolivre.opinions;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.products.Product;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "opinions")
public class Opinion {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Range(min = 1, max = 5)
    private Integer review;

    @Column(nullable = false, length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_id"))
    private User author;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product_id"))
    private Product product;

    /**
     * @deprecated Hibernate only.
     */
    public Opinion() {
    }

    public Opinion(String title, Integer review, String description) {
        this.title = title;
        this.review = review;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getReview() {
        return review;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public Product getProduct() {
        return product;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
