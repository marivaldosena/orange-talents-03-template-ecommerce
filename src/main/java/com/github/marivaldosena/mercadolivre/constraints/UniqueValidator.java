package com.github.marivaldosena.mercadolivre.constraints;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValidator implements ConstraintValidator<Unique, String> {
    @Autowired
    private EntityManager manager;

    private Class<?> entity;
    private String fieldName;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String jpql = "SELECT 1 FROM " + entity.getName() + " WHERE LOWER(" + fieldName + ") = LOWER(:value)";
        Query query = manager.createQuery(jpql);
        query.setParameter("value", value);
        List<?> result = query.getResultList();
        return result.isEmpty();
    }

    @Override
    public void initialize(Unique constraint) {
        this.entity = constraint.entity();
        this.fieldName = constraint.field();
    }
}
