package org.ahmedukamel.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.request.CredentialsRequest;
import org.ahmedukamel.ecommerce.service.AuthService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/auth")
public class AuthController {
    private final AuthService service;

    @PostMapping(value = "register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody CredentialsRequest request) {
        ApiResponse response = service.register(request);
        return ResponseUtils.acceptedResponse(response);
    }

    @PostMapping(value = "login")
    public ResponseEntity<ApiResponse> login(@RequestBody CredentialsRequest request) {
        ApiResponse response = service.login(request);
        return ResponseUtils.acceptedResponse(response);
    }
}
