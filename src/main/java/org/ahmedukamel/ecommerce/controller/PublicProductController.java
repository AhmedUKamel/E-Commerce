package org.ahmedukamel.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.service.ProductService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/public/product")
public class PublicProductController {
    private final ProductService service;

    @GetMapping(value = "all")
    public ResponseEntity<ApiResponse> getAllProducts() {
        ApiResponse response = service.getAllProducts();
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable(value = "productId") Integer productId) {
        ApiResponse response = service.getProduct(productId);
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "category/{categoryId}")
    public ResponseEntity<ApiResponse> getCategoryProducts(@PathVariable(value = "categoryId") Integer categoryId) {
        ApiResponse response = service.getCategoryProducts(categoryId);
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "main/category/{mainCategoryId}")
    public ResponseEntity<ApiResponse> getMainCategoryProducts(@PathVariable(value = "mainCategoryId") Integer mainCategoryId) {
        ApiResponse response = service.getMainCategoryProducts(mainCategoryId);
        return ResponseUtils.acceptedResponse(response);
    }
}