package org.ahmedukamel.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String code;
}
