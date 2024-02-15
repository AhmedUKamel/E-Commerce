package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface ReportService {
    ApiResponse getAllReports();

    ApiResponse getProductReports(Integer productId);

    ApiResponse getReviewReports(Integer reviewId);

    ApiResponse getReportsFromCustomer(Integer customerId);

    ApiResponse getReportsToCustomer(Integer customerId);
}
