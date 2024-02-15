package org.ahmedukamel.ecommerce.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ahmedukamel.ecommerce.util.DateTimeUtils;
import org.ahmedukamel.ecommerce.validation.validators.DateTimeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface ValidDateTime {
    String message() default "{validation.constrains.ValidDateTime.message}";

    String format() default DateTimeUtils.DATE_TIME_PATTERN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
