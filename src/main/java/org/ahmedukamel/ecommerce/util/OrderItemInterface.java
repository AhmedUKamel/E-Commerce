package org.ahmedukamel.ecommerce.util;

import org.ahmedukamel.ecommerce.model.Product;

public interface OrderItemInterface {
    Product getProduct();

    Integer getQuantity();
}
