package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.AddressDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface AddressService {
    ApiResponse addAddress(AddressDto request);

    ApiResponse deleteAddress(Integer addressId);

    ApiResponse getAddresses();
}
