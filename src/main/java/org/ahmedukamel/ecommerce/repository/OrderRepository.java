package org.ahmedukamel.ecommerce.repository;

import org.ahmedukamel.ecommerce.model.Order;
import org.ahmedukamel.ecommerce.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByStatus(OrderStatus status);
}
