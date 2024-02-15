package org.ahmedukamel.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "main_categories")
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @JsonIgnore
    @OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MainCategoryDetail> mainCategoryDetails = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Category> categories = new HashSet<>();
}
