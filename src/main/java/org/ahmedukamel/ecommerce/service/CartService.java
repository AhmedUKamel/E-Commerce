package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.request.CartRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface CartService {
    ApiResponse getCart();

    ApiResponse updateCart(CartRequest request);

    ApiResponse removeFromCart(Integer productId);
}
