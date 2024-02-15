package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

import java.io.IOException;

public interface PublicService {
    ApiResponse getAllCategories();

    ApiResponse getAllMainCategories();

    ApiResponse getMainCategoryCategories(Integer mainCategoryId);

    ApiResponse getAllCountries();

    byte[] viewPicture(String picturePath) throws IOException;
}
