package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.CustomerDto;
import org.ahmedukamel.ecommerce.dto.request.UpdatePasswordRequest;

public interface ProfileService {
    ApiResponse updateUser(CustomerDto request);

    ApiResponse updatePassword(UpdatePasswordRequest request);

    ApiResponse getProfile();

    ApiResponse getNotifications();
}
