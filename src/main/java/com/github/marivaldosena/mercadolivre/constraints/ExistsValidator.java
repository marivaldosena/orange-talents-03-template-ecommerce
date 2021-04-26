package com.github.marivaldosena.mercadolivre.constraints;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsValidator implements ConstraintValidator<Exists, String> {
    @PersistenceContext
    private EntityManager manager;

    Class<?> entity;
    String[] fieldNames;
    boolean isRequired;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // if field is not required and is empty, it should pass validation, otherwise proceeds
        if (!isRequired && value == null) {
            return true;
        }

        String jpql = "SELECT 1 FROM " + entity.getName() + " WHERE ";

        for (String field : fieldNames) {
            jpql = jpql + "LOWER(" + field + ") = LOWER(:value) OR ";
        }

        jpql = jpql.substring(0, jpql.length() - 3);

        Query query = manager.createQuery(jpql);
        query.setParameter("value", value);
        List<?> result = query.getResultList();
        return value != null && result.size() > 0;
    }

    @Override
    public void initialize(Exists constraint) {
        this.entity = constraint.entity();
        this.fieldNames = constraint.fields();
        this.isRequired = constraint.required();
    }
}
