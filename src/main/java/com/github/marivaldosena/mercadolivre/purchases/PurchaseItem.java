package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.products.Product;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "purchase_items")
public class PurchaseItem {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Column(name = "product")
    private String productName;

    private Integer quantity;

    private BigDecimal paidPrice;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "purchase_id", nullable = false, foreignKey = @ForeignKey(name = "fk_items_purchase_id"))
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    /**
     * @deprecated Hibernate only.
     */
    public PurchaseItem() {
    }


    public PurchaseItem(Product product, Integer quantity, Purchase purchase) {
        this.productName = product.getName();
        this.quantity = quantity;
        this.paidPrice = product.getPrice();
        this.product = product;
        this.seller = product.getUser();
        this.purchase = purchase;
    }

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    /**
     * Purchased product at the time. However, the product could be deleted in some future date, so it means
     * that we could have no product available.
     * @return Purchased product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Product seller. However, it may be non-existent at the time we try to get this information since
     * the user can delete one's own account.
     * @return Product seller.
     */
    public User getSeller() {
        return seller;
    }

    public Purchase getPurchase() {
        return purchase;
    }
}
