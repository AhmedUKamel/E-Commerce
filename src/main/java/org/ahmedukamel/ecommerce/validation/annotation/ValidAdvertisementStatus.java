package org.ahmedukamel.ecommerce.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ahmedukamel.ecommerce.validation.validators.AdvertisementStatusValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AdvertisementStatusValidator.class)
public @interface ValidAdvertisementStatus {
    String message() default "{validation.constrains.ValidAdvertisementStatus.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
