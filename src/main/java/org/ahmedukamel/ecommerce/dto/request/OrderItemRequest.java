package org.ahmedukamel.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;
import org.ahmedukamel.ecommerce.util.OrderItemInterface;
import org.ahmedukamel.ecommerce.model.Product;
import org.ahmedukamel.ecommerce.validation.annotation.ValidProduct;

@Data
public class OrderItemRequest implements OrderItemInterface {
    @ValidProduct
    private Integer productId;
    @Min(value = 1)
    private Integer quantity;
    private Product product;
}
