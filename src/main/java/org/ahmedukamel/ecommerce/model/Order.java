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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime orderDate;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
    @Column(nullable = false)
    private Double totalAmount;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Shipment shipment;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();
}
