package com.github.marivaldosena.mercadolivre.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByName(String productName);
    @Query(value = "SELECT * FROM products p WHERE LOWER(p.name) = LOWER(:idOrName) OR p.id = :idOrName",
    countQuery = "SELECT COUNT(id) FROM products p WHERE LOWER(p.name) = LOWER(:idOrName) OR p.id = :idOrName",
    nativeQuery = true)
    Optional<Product> findProductByIdOrName(String idOrName);
}
