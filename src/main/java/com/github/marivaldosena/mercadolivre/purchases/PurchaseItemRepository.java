package com.github.marivaldosena.mercadolivre.purchases;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, UUID> {
}
