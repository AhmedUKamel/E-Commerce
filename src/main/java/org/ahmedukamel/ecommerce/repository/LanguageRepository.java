package org.ahmedukamel.ecommerce.repository;

import org.ahmedukamel.ecommerce.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    Optional<Language> findByCodeIgnoreCase(String code);
}
