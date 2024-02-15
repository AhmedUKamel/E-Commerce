package org.ahmedukamel.ecommerce.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ahmedukamel.ecommerce.validation.validators.ProductValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductValidator.class)
public @interface ValidProduct {
    String message() default "{validation.constrains.ValidProduct.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
