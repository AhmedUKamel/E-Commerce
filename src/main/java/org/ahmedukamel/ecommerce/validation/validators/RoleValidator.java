package org.ahmedukamel.ecommerce.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ahmedukamel.ecommerce.model.Role;
import org.ahmedukamel.ecommerce.validation.annotation.ValidRole;

public class RoleValidator implements ConstraintValidator<ValidRole, String> {
    @Override
    public boolean isValid(String role, ConstraintValidatorContext context) {
        try {
            Role.valueOf(role.toUpperCase());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
