package com.github.marivaldosena.mercadolivre.categories;

import com.github.marivaldosena.mercadolivre.products.Product;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, insertable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Category> children;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    /**
     * @deprecated Hibernate only.
     */
    public Category() {
    }

    /**
     *
     * @param name Category name.
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     *
     * @param name Category name.
     * @param parent Parent category.
     */
    public Category(String name, Category parent) {
        this(name);
        this.parent = parent;
    }

    public void setParentCategory(Category parent) {
        this.parent = parent;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }

    public Set<Category> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
