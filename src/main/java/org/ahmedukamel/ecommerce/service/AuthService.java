package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.request.CredentialsRequest;

public interface AuthService {
    ApiResponse register(CredentialsRequest request);

    ApiResponse login(CredentialsRequest request);
}
