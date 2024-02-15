package org.ahmedukamel.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    private Double rating;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dateCreated;

    @JsonIgnore
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReviewReport> reports = new HashSet<>();
}