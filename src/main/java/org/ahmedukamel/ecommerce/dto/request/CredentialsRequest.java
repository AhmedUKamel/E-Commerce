package org.ahmedukamel.ecommerce.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

import static org.ahmedukamel.ecommerce.validation.Validator.PHONE_PATTERN;

@Data
public class CredentialsRequest {
    @Email
    @NotNull
    private String email;
    @NotBlank
    private String password;
    @NotNull
    @Pattern(regexp = PHONE_PATTERN)
    private String phone;
    public boolean rememberMe;
}
