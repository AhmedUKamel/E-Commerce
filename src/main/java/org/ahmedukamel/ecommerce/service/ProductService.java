package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ApiResponse addProduct(ProductDto request);

    ApiResponse updateProduct(ProductDto request, Integer productId);

    ApiResponse uploadProductImage(Integer productId, MultipartFile file) throws IOException;

    ApiResponse deleteProductImage(Integer productId, String pictureName);

    ApiResponse getProduct(Integer productId);

    ApiResponse getAllProducts();

    ApiResponse getCategoryProducts(Integer categoryId);

    ApiResponse getMainCategoryProducts(Integer mainCategoryId);
}