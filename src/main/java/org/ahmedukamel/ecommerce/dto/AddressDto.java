package org.ahmedukamel.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.ahmedukamel.ecommerce.validation.annotation.ValidCountry;

@Data
public class AddressDto {
    @ValidCountry
    private String country;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String region;
    @NotBlank
    private String zipCode;
    // Data for response
    private Integer addressId;
}
