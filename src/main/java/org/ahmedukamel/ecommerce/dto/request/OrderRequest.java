package org.ahmedukamel.ecommerce.dto.request;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @Valid
    private List<OrderItemRequest> orderItems;
}
