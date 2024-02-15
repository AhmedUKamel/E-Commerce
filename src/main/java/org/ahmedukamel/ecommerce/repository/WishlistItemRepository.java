package org.ahmedukamel.ecommerce.repository;

import org.ahmedukamel.ecommerce.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Integer> {
    @Query(value = "SELECT wi.product.productId FROM WishlistItem wi WHERE wi.wishlist.customer.customerId = :customerId")
    List<Integer> getProductsIds(@Param(value = "customerId") Integer customerId);

    boolean existsByWishlist_Customer_CustomerIdAndProduct_ProductId(Integer customerId, Integer productId);
}
