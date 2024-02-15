package org.ahmedukamel.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String phone;
    // Data for response
    private Integer customerId;
    private String role;
    private Boolean enabled;
}
