package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.request.ReportRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface CustomerReportService {
    ApiResponse reportReview(ReportRequest request);

    ApiResponse getReports();

    ApiResponse getReportTypes();
}
