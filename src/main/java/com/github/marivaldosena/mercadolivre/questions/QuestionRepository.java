package com.github.marivaldosena.mercadolivre.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    @Query(value = "SELECT * FROM questions q WHERE title = :title AND q.user_id = :userId AND q.product_id = :productId",
            countQuery = "SELECT COUNT(q.id) FROM questions q WHERE title = :title AND q.user_id = :userId AND q.product_id = :productId",
            nativeQuery = true)
    List<Question> findSimilarQuestions(String title, UUID userId, UUID productId);
}
