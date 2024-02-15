package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.AdvertisementDto;
import org.ahmedukamel.ecommerce.dto.request.AdStatusRequest;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdvertisementService {
    ApiResponse addAdvertisement(AdvertisementDto request);

    ApiResponse updateAdvertisement(Integer advertisementId, AdvertisementDto request);

    ApiResponse deleteAdvertisement(Integer advertisementId);

    ApiResponse setAdvertisementStatus(AdStatusRequest request);

    ApiResponse getAdvertisementStatuses();

    ApiResponse getAdvertisement(Integer advertisementId);

    ApiResponse getAllAdvertisements();

    ApiResponse getActiveAdvertisements();

    ApiResponse getInactiveAdvertisements();

    ApiResponse getPendingAdvertisements();

    ApiResponse getPausedAdvertisements();

    ApiResponse getExpiredAdvertisements();

    ApiResponse uploadAdvertisementPicture(Integer advertisementId, MultipartFile image) throws IOException;

    ApiResponse deleteAdvertisementPicture(Integer advertisementId);
}