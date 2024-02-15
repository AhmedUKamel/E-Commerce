package org.ahmedukamel.ecommerce.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.response.WishlistResponse;
import org.ahmedukamel.ecommerce.mapper.WishlistMapper;
import org.ahmedukamel.ecommerce.model.Customer;
import org.ahmedukamel.ecommerce.model.Language;
import org.ahmedukamel.ecommerce.model.Product;
import org.ahmedukamel.ecommerce.model.WishlistItem;
import org.ahmedukamel.ecommerce.repository.CustomerRepository;
import org.ahmedukamel.ecommerce.repository.LanguageRepository;
import org.ahmedukamel.ecommerce.repository.ProductRepository;
import org.ahmedukamel.ecommerce.service.WishlistService;
import org.ahmedukamel.ecommerce.util.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
@Transactional
public class WishlistServiceImpl implements WishlistService {
    private final MessageSourceUtils messageSourceUtils;
    private final CustomerRepository customerRepository;
    private final LanguageRepository languageRepository;
    private final ProductRepository productRepository;

    @Override
    public ApiResponse getWishlist() {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        Language language = RepositoryUtils.getLanguage(languageRepository, LocaleContextUtils.getLanguage());
        // Processing
        WishlistResponse wishlist = WishlistMapper.toResponse(customer.getWishlist(), language.getLanguageId());
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.get.wishlist");
        return new ApiResponse(true, message, Map.of("wishlist", wishlist));
    }

    @Override
    public ApiResponse addWishlistItem(Integer productId) {
        // Querying
        Product product = RepositoryUtils.getProduct(productRepository, productId);
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        // Validating
        ValidationUtils.validateExistWishlistItem(customer, productId, messageSourceUtils);
        // Processing
        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setWishlist(customer.getWishlist());
        wishlistItem.setProduct(product);
        customer.getWishlist().getWishlistItems().add(wishlistItem);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.add.wishlist.item");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse deleteWishlistItem(Integer productId) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        // Validating
        RepositoryService.checkNotExistProduct(productRepository, productId);
        WishlistItem wishlistItem = ValidationUtils.validaGetWishlistItem(customer.getWishlist().getWishlistItems(), productId, messageSourceUtils);
        // Processing
        customer.getWishlist().getWishlistItems().remove(wishlistItem);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.remove.wishlist.item");
        return new ApiResponse(true, message);
    }
}