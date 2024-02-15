package org.ahmedukamel.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.request.ReportRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.service.CustomerReportService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/user/report")
public class CustomerReportController {
    private final CustomerReportService service;

    @PostMapping(value = "new")
    public ResponseEntity<ApiResponse> reportReview(@Valid @RequestBody ReportRequest request) {
        ApiResponse response = service.reportReview(request);
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "my")
    public ResponseEntity<ApiResponse> getReports() {
        ApiResponse response = service.getReports();
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "type/all")
    public ResponseEntity<ApiResponse> getReportTypes() {
        ApiResponse response = service.getReportTypes();
        return ResponseUtils.acceptedResponse(response);
    }
}
