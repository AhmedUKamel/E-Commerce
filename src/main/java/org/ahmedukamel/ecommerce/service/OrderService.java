package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.request.OrderRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface OrderService {
    ApiResponse createOrder(Integer addressId);

    ApiResponse createOrder(OrderRequest request, Integer addressId);

    ApiResponse cancelOrder(Integer orderId);

    ApiResponse getOrder(Integer orderId);

    ApiResponse getAllOrders();

    ApiResponse getPreparedOrders();

    ApiResponse getDeliveredOrders();

    ApiResponse getCanceledOrders();
}
