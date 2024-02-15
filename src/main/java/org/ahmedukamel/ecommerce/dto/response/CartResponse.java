package org.ahmedukamel.ecommerce.dto.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartResponse {
    private Integer cartId;
    private List<CartItemResponse> cartItems;
}
