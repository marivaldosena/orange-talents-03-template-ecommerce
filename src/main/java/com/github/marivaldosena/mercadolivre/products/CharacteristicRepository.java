package com.github.marivaldosena.mercadolivre.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CharacteristicRepository extends JpaRepository<Characteristic, UUID> {
    Optional<Characteristic> findByName(String name);
}
