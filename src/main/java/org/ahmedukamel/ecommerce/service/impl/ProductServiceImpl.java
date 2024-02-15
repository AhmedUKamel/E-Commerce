package org.ahmedukamel.ecommerce.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.ProductDto;
import org.ahmedukamel.ecommerce.mapper.ProductMapper;
import org.ahmedukamel.ecommerce.model.*;
import org.ahmedukamel.ecommerce.repository.CategoryRepository;
import org.ahmedukamel.ecommerce.repository.LanguageRepository;
import org.ahmedukamel.ecommerce.repository.MainCategoryRepository;
import org.ahmedukamel.ecommerce.repository.ProductRepository;
import org.ahmedukamel.ecommerce.service.ProductService;
import org.ahmedukamel.ecommerce.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final MainCategoryRepository mainCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final LanguageRepository languageRepository;
    private final HttpServletRequest httpServletRequest;
    private final MessageSourceUtils messageSourceUtils;
    private final ProductRepository productRepository;

    @Override
    public ApiResponse addProduct(ProductDto request) {
        // Querying
        Language language = RepositoryUtils.getLanguage(languageRepository, LocaleContextUtils.getLanguage());
        Category category = RepositoryUtils.getCategory(categoryRepository, request.getCategoryId());
        // Processing
        Product product = new Product();
        product.setRating(0D);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setLanguage(language);
        UpdateUtils.updateProduct(request, product, category);
        UpdateUtils.updateProductDetail(request, productDetail);
        product.getProductDetails().add(productDetail);
        category.getProducts().add(product);
        categoryRepository.save(category);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.add.product");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse updateProduct(ProductDto request, Integer productId) {
        // Querying
        Language language = RepositoryUtils.getLanguage(languageRepository, LocaleContextUtils.getLanguage());
        Product product = RepositoryUtils.getProduct(productRepository, productId);
        // Validation
        Category category = ValidationUtils.validateGetCategory(categoryRepository, request);
        // Processing
        ProductDetail productDetail = EntityDetailsUtils.supplyProductDetail(product, language.getLanguageId());
        productDetail.setProduct(product);
        productDetail.setLanguage(language);
        UpdateUtils.updateProduct(request, product, category);
        UpdateUtils.updateProductDetail(request, productDetail);
        product.getProductDetails().add(productDetail);
        productRepository.save(product);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.update.product");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse uploadProductImage(Integer productId, MultipartFile file) throws IOException {
        // Querying
        Product product = RepositoryUtils.getProduct(productRepository, productId);
        // Validation
        ValidationUtils.validateProductPictures(product, messageSourceUtils);
        // Processing
        String imageName = ImageDirectoryUtils.saveImage(file);
        String imageUrl = ImageDirectoryUtils.getImageUrl(imageName, httpServletRequest);
        product.getPictures().add(imageUrl);
        productRepository.save(product);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.upload.product.picture");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse deleteProductImage(Integer productId, String imageName) {
        // Querying
        Product product = RepositoryUtils.getProduct(productRepository, productId);
        // Validating
        String imageUrl = ValidationUtils.validateGetProductPicture(product, imageName, messageSourceUtils);
        ImageDirectoryUtils.deleteImage(imageUrl);
        product.getPictures().remove(imageUrl);
        productRepository.save(product);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.delete.product.picture");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse getProduct(Integer productId) {
        // Querying
        Language language = RepositoryUtils.getLanguage(languageRepository, LocaleContextUtils.getLanguage());
        Product product = RepositoryUtils.getProduct(productRepository, productId);
        // Processing
        ProductDto productDto = ProductMapper.toResponse(product, language.getLanguageId());
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.get.product");
        return new ApiResponse(true, message, Map.of("product", productDto));
    }

    @Override
    public ApiResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        return getProducts(products);
    }

    @Override
    public ApiResponse getCategoryProducts(Integer categoryId) {
        Category category = RepositoryUtils.getCategory(categoryRepository, categoryId);
        Collection<Product> products = category.getProducts();
        return getProducts(products);
    }

    @Override
    public ApiResponse getMainCategoryProducts(Integer mainCategoryId) {
        RepositoryUtils.getMainCategory(mainCategoryRepository, mainCategoryId);
        Collection<Product> products = productRepository.findAllByCategory_MainCategory_CategoryId(mainCategoryId);
        return getProducts(products);
    }

    private ApiResponse getProducts(Collection<Product> products) {
        // Querying
        Language language = RepositoryUtils.getLanguage(languageRepository, LocaleContextUtils.getLanguage());
        // Processing
        List<ProductDto> productDtoList = ProductMapper.toResponse(products, language.getLanguageId());
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.get.products");
        return new ApiResponse(true, message, Map.of("products", productDtoList));
    }
}
