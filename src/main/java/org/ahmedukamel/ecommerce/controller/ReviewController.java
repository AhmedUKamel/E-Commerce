package org.ahmedukamel.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.ReviewDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.service.ReviewService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/user/review")
public class ReviewController {
    private final ReviewService service;

    @PostMapping(value = "new")
    public ResponseEntity<ApiResponse> addReview(@Valid @RequestBody ReviewDto request) {
        ApiResponse response = service.addReview(request);
        return ResponseUtils.acceptedResponse(response);
    }

    @PutMapping(value = "update/{reviewId}")
    public ResponseEntity<ApiResponse> updateReview(@PathVariable(value = "reviewId") Integer reviewId, @RequestBody ReviewDto request) {
        ApiResponse response = service.updateReview(request, reviewId);
        return ResponseUtils.acceptedResponse(response);
    }

    @DeleteMapping(value = "delete/{reviewId}")
    public ResponseEntity<ApiResponse> deleteReview(@PathVariable(value = "reviewId") Integer reviewId) {
        ApiResponse response = service.deleteReview(reviewId);
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "all")
    public ResponseEntity<ApiResponse> getReviews() {
        ApiResponse response = service.getUserReviews();
        return ResponseUtils.acceptedResponse(response);
    }
}
