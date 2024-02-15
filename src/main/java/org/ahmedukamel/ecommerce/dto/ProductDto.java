package org.ahmedukamel.ecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.ahmedukamel.ecommerce.validation.annotation.ValidCategory;

import java.util.List;

@Data
public class ProductDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String about;
    @NotNull
    @Min(value = 0)
    private Double price;
    @NotNull
    @Min(value = -1)
    private Double afterDiscount;
    @NotNull
    @Min(value = 0)
    private Integer stockQuantity;
    @ValidCategory
    private Integer categoryId;
    // Data for response
    private Integer productId;
    private Integer reviews;
    private Double rating;
    private Boolean discount;
    private Boolean inWishlist;
    private Boolean inCart;
    private List<String> pictures;
}
