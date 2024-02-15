package org.ahmedukamel.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "main_category_details")
public class MainCategoryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description = "";
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private MainCategory mainCategory;
    @ManyToOne
    @JoinColumn(name = "language", nullable = false)
    private Language language;
}
