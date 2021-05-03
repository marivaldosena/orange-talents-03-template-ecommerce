package com.github.marivaldosena.mercadolivre.purchases;

import com.github.marivaldosena.mercadolivre.auth.User;
import com.github.marivaldosena.mercadolivre.purchases.gateway.GatewayType;
import com.github.marivaldosena.mercadolivre.purchases.gateway.PaymentGateway;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", insertable = false, updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "gateway")
    private GatewayType gatewayType;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.REMOVE, CascadeType.MERGE })
    private List<PurchaseItem> items;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_purchase_buyer_id"))
    private User buyer;

    @Column(name = "transaction_id")
    private String transaction;

    @Transient
    private PaymentGateway paymentGateway;

    /**
     * @deprecated Hibernate only.
     */
    public Purchase() {
    }

    /**
     *
     * @param buyer Buyer identification.
     * @param gatewayType Payment Gateway.
     */
    public Purchase(User buyer, GatewayType gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = gatewayType.getGateway(this, "http://localhost:8080/purchases/payment");
        this.buyer = buyer;
        this.status = PurchaseStatus.STARTED;
        this.items = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public GatewayType getGatewayType() {
        return gatewayType;
    }

    public List<PurchaseItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public User getBuyer() {
        return buyer;
    }

    public String getTransaction() {
        return transaction;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }

    public void setTransaction(String transaction) {
        this.status = PurchaseStatus.COMPLETED;
        this.transaction = transaction;
    }
}
