package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface CustomerService {
    ApiResponse demandProduct(Integer productId);
}
