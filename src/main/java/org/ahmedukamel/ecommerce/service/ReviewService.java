package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.ReviewDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface ReviewService {
    ApiResponse addReview(ReviewDto request);

    ApiResponse updateReview(ReviewDto request, Integer reviewId);

    ApiResponse deleteReview(Integer reviewId);

    ApiResponse getUserReviews();

    ApiResponse getAllReviews();

    ApiResponse getProductReviews(Integer productId);

    ApiResponse getReview(Integer reviewId);
}
