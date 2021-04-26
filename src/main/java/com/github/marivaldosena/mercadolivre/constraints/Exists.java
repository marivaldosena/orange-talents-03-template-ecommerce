package com.github.marivaldosena.mercadolivre.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Exists {
    String message() default "Nonexistent value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> entity();
    String[] fields();
    boolean required() default true;
}
