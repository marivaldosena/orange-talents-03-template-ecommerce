package com.github.marivaldosena.mercadolivre.products;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.categories.Category;
import com.github.marivaldosena.mercadolivre.errors.UnavailableStockException;
import com.github.marivaldosena.mercadolivre.images.ProductImage;
import com.github.marivaldosena.mercadolivre.opinions.Opinion;
import com.github.marivaldosena.mercadolivre.questions.Question;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, insertable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 1000)
    private String description;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "product_details",
            joinColumns = { @JoinColumn(name = "product_id")},
            inverseJoinColumns = { @JoinColumn(name = "characteristic_id")})
    private Set<Characteristic> details;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false,
        foreignKey = @ForeignKey(name = "fk_category_id"))
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false,
        foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private Set<ProductImage> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<Opinion> opinions;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<Question> questions;

    /**
     * @deprecated Hibernate only;
     */
    public Product() {
    }

    /**
     *
     * @param name Product name.
     * @param price Purchase price.
     * @param quantity Available quantity.
     * @param description Product description.
     */
    public Product(String name, BigDecimal price, Integer quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.details = new HashSet<>();
        this.images = new HashSet<>();
        this.opinions = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Set<Characteristic> getDetails() {
        return Collections.unmodifiableSet(details);
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public Set<ProductImage> getImages() {
        return Collections.unmodifiableSet(images);
    }

    public List<Opinion> getOpinions() {
        return Collections.unmodifiableList(opinions);
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public void setDetails(Set<Characteristic> details) {
        this.details = details;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCurrentUserTheOwner(User currentUser) {
        return this.getUser().getEmail().compareTo(currentUser.getEmail()) == 0;
    }

    /**
     * Check stock availability for a given number of items to be sold.
     * @param desiredQuantity Desired number of items to be sold.
     * @return Whether the number of products is enough for a given order or not.
     */
    public boolean isStockAvailableFor(Integer desiredQuantity) {
        if (desiredQuantity <= quantity) {
            return true;
        }

        return false;
    }

    /**
     * Deplete product stock by a given number. If stock is unavailable it throws an UnavailableStockExcpetion.
     * @param desiredQuantity
     * @throws UnavailableStockException
     */
    public void depleteStockBy(Integer desiredQuantity) throws UnavailableStockException {
        if (!isStockAvailableFor(desiredQuantity)) {
            throw new UnavailableStockException("Stock unavailable for " + name);
        }

        this.quantity -= desiredQuantity;
    }
}
