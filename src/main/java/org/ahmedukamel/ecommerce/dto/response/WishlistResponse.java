package org.ahmedukamel.ecommerce.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class WishlistResponse {
    private Integer id;
    private List<WishlistItemResponse> wishlistItems;
}
