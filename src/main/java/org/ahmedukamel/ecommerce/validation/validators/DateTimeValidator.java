package org.ahmedukamel.ecommerce.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ahmedukamel.ecommerce.util.DateTimeUtils;
import org.ahmedukamel.ecommerce.validation.annotation.ValidDateTime;

public class DateTimeValidator implements ConstraintValidator<ValidDateTime, String> {
    @Override
    public boolean isValid(String dateTime, ConstraintValidatorContext constraintValidatorContext) {
        try {
            DateTimeUtils.getDateTime(dateTime);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
