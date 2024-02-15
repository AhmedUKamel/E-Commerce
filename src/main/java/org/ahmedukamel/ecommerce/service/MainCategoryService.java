package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.MainCategoryDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface MainCategoryService {
    ApiResponse addMainCategory(MainCategoryDto request);

    ApiResponse updateMainCategory(MainCategoryDto request, Integer mainCategoryId);

    ApiResponse deleteMainCategory(Integer mainCategoryId);
}
