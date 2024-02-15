package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.MessageRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface DeliveryService {
    ApiResponse getPreparedOrders();

    ApiResponse getShippedOrders();

    ApiResponse getOutForDeliverOrders();

    ApiResponse setOrderShipped(Integer orderId, MessageRequest request);

    ApiResponse setOrderOutForDeliver(Integer orderId);

    ApiResponse setOrderDelivered(Integer orderId);
}
