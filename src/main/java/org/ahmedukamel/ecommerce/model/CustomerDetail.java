package org.ahmedukamel.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_details")
public class CustomerDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName = "";
    private String lastName = "";
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}