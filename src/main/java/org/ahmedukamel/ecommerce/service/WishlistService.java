package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface WishlistService {
    ApiResponse getWishlist();

    ApiResponse addWishlistItem(Integer productId);

    ApiResponse deleteWishlistItem(Integer productId);
}
