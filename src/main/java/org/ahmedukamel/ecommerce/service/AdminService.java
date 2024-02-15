package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface AdminService {
    ApiResponse deleteReview(Integer reviewId);

    ApiResponse resetDemands(Integer productId);

    ApiResponse resetDemandsAndNotify(Integer productId, String message);
}
