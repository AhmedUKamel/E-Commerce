package org.ahmedukamel.ecommerce.validation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.repository.CustomerRepository;
import org.ahmedukamel.ecommerce.validation.annotation.ValidCustomer;

@RequiredArgsConstructor
public class CustomerValidator implements ConstraintValidator<ValidCustomer, Integer> {
    private final CustomerRepository customerRepository;

    @Override
    public boolean isValid(Integer customerId, ConstraintValidatorContext context) {
        return customerId != null && customerRepository.existsById(customerId);
    }
}
