package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface CustomerViewService {
    ApiResponse getPostForCustomer(Integer postId);

    ApiResponse getAllPostsForCustomer();

    ApiResponse getProductForCustomer(Integer productId);

    ApiResponse getAllProductsForCustomer();

    ApiResponse getCategoryProductsForCustomer(Integer categoryId);

    ApiResponse getMainCategoryProductsForCustomer(Integer mainCategoryId);
}
