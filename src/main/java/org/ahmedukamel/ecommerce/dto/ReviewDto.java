package org.ahmedukamel.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.ahmedukamel.ecommerce.validation.annotation.ValidProduct;
import org.hibernate.validator.constraints.Range;


@Data
public class ReviewDto {
    @ValidProduct
    private Integer productId;
    @NotNull
    @Range(min = 1, max = 5)
    private Double rating;
    @NotBlank
    private String comment;
    // Data for response
    private Integer reviewId;
    private String email;
    private String dataCreated;
}
