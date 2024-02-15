package org.ahmedukamel.ecommerce.repository;

import org.ahmedukamel.ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Query(value = "SELECT ci.product.productId FROM CartItem ci WHERE ci.cart.customer.customerId = :customerId")
    List<Integer> getProductsIds(@Param(value = "customerId") Integer customerId);

    boolean existsByCart_Customer_CustomerIdAndProduct_ProductId(Integer customerId, Integer productId);
}
