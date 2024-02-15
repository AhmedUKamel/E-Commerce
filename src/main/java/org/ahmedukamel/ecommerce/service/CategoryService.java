package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.CategoryDto;

public interface CategoryService {
    ApiResponse addCategory(CategoryDto request);

    ApiResponse updateCategory(CategoryDto request, Integer categoryId);

    ApiResponse deleteCategory(Integer categoryId);
}
