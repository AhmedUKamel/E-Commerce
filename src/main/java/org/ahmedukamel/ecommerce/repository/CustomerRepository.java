package org.ahmedukamel.ecommerce.repository;

import org.ahmedukamel.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmailIgnoreCase(String email);

    Optional<Customer> findByEmailIgnoreCaseOrPhone(String email, String phone);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPhone(String phone);

}
