package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.request.NotificationRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface NotificationService {
    ApiResponse notifyCustomers(NotificationRequest request);

    ApiResponse notifyAllCustomers(String message);

    ApiResponse updateNotification(Integer notificationId, String message);
}
