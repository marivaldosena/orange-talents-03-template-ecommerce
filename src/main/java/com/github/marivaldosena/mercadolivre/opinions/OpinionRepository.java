package com.github.marivaldosena.mercadolivre.opinions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpinionRepository extends JpaRepository<Opinion, UUID> {
}
