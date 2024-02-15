package org.ahmedukamel.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Double unitPrice;
    @Column(nullable = false)
    private Double totalPrice;

    public OrderItem(Order order, Product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = unitPrice * quantity;
        if (product.getDiscount()) {
            this.unitPrice = product.getAfterDiscount();
        } else {
            this.unitPrice = product.getPrice();
        }
    }
}
