package org.ahmedukamel.ecommerce.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ahmedukamel.ecommerce.validation.validators.AdvertisementValidator;

import java.lang.annotation.*;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AdvertisementValidator.class)
public @interface ValidAdvertisement {
    String message() default "{validation.constrains.ValidAdvertisement.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
