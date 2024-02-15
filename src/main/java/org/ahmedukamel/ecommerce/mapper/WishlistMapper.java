package org.ahmedukamel.ecommerce.mapper;

import org.ahmedukamel.ecommerce.dto.response.WishlistItemResponse;
import org.ahmedukamel.ecommerce.dto.response.WishlistResponse;
import org.ahmedukamel.ecommerce.model.Product;
import org.ahmedukamel.ecommerce.model.ProductDetail;
import org.ahmedukamel.ecommerce.model.Wishlist;
import org.ahmedukamel.ecommerce.model.WishlistItem;
import org.ahmedukamel.ecommerce.util.EntityDetailsUtils;

import java.util.List;

public class WishlistMapper {
    public static WishlistResponse toResponse(Wishlist wishlist, Integer languageId) {
        WishlistResponse response = new WishlistResponse();
        response.setId(wishlist.getWishlistId());
        response.setWishlistItems(getWishlistItems(wishlist.getWishlistItems(), languageId));
        return response;
    }

    private static WishlistItemResponse toResponse(Product product, Integer languageId) {
        ProductDetail productDetail = EntityDetailsUtils.supplyProductDetail(product, languageId);
        WishlistItemResponse response = new WishlistItemResponse();
        response.setProductId(product.getProductId());
        response.setProductPrice(product.getPrice());
        response.setProductName(productDetail.getName());
        response.setProductDescription(productDetail.getDescription());
        response.setRating(product.getRating());
        response.setPictureUrl(product.getPictures().isEmpty() ? "" : product.getPictures().get(0));
        response.setDiscount(product.getDiscount());
        response.setAfterDiscount(product.getAfterDiscount());
        return response;
    }

    private static List<WishlistItemResponse> getWishlistItems(List<WishlistItem> items, Integer languageId) {
        return items.stream().map(item -> WishlistMapper.toResponse(item.getProduct(), languageId)).toList();
    }
}