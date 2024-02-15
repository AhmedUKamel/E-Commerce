package org.ahmedukamel.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.request.OrderRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.service.OrderService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/user/order")
public class OrderController {
    private final OrderService service;

    @PostMapping(value = "cart/on/{addressId}")
    public ResponseEntity<ApiResponse> createOrder(@PathVariable(value = "addressId") Integer addressId) {
        ApiResponse response = service.createOrder(addressId);
        return ResponseUtils.acceptedResponse(response);
    }

    @PostMapping(value = "new/on/{addressId}")
    public ResponseEntity<ApiResponse> createOrder(@PathVariable(value = "addressId") Integer addressId, @Valid @RequestBody OrderRequest request) {
        ApiResponse response = service.createOrder(request, addressId);
        return ResponseUtils.acceptedResponse(response);
    }

    @DeleteMapping(value = "cancel/{orderId}")
    public ResponseEntity<ApiResponse> cancelOrder(@PathVariable(value = "orderId") Integer orderId) {
        ApiResponse response = service.cancelOrder(orderId);
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "{orderId}")
    public ResponseEntity<ApiResponse> getOrder(@PathVariable(value = "orderId") Integer orderId) {
        ApiResponse response = service.getOrder(orderId);
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "all")
    public ResponseEntity<ApiResponse> getAllOrders() {
        ApiResponse response = service.getAllOrders();
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "prepared")
    public ResponseEntity<ApiResponse> getPreparedOrders() {
        ApiResponse response = service.getPreparedOrders();
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "delivered")
    public ResponseEntity<ApiResponse> getDeliveredOrders() {
        ApiResponse response = service.getDeliveredOrders();
        return ResponseUtils.acceptedResponse(response);
    }

    @GetMapping(value = "canceled")
    public ResponseEntity<ApiResponse> getCanceledOrders() {
        ApiResponse response = service.getCanceledOrders();
        return ResponseUtils.acceptedResponse(response);
    }
}
