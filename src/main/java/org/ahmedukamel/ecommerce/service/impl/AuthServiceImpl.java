package org.ahmedukamel.ecommerce.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.dto.request.CredentialsRequest;
import org.ahmedukamel.ecommerce.mapper.CustomerMapper;
import org.ahmedukamel.ecommerce.model.Cart;
import org.ahmedukamel.ecommerce.model.Customer;
import org.ahmedukamel.ecommerce.model.Role;
import org.ahmedukamel.ecommerce.model.Wishlist;
import org.ahmedukamel.ecommerce.repository.CustomerRepository;
import org.ahmedukamel.ecommerce.service.AuthService;
import org.ahmedukamel.ecommerce.util.JwtUtils;
import org.ahmedukamel.ecommerce.util.MessageSourceUtils;
import org.ahmedukamel.ecommerce.util.RepositoryUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final CustomerRepository customerRepository;
    private final MessageSourceUtils messageSourceUtils;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse register(CredentialsRequest request) {
        // Validating
        RepositoryService.checkExistEmail(customerRepository, request.getEmail());
        RepositoryService.checkExistPhone(customerRepository, request.getPhone());
        // Processing
        Customer customer = CustomerMapper.toCustomer(passwordEncoder, request);
        Cart cart = new Cart();
        Wishlist wishlist = new Wishlist();
        customer.setCart(cart);
        customer.setWishlist(wishlist);
        cart.setCustomer(customer);
        wishlist.setCustomer(customer);
        customerRepository.save(customer);
        String token = JwtUtils.generateToken(customer, request.rememberMe);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.register");
        return new ApiResponse(true, message, Map.of("token", token));
    }

    @Override
    public ApiResponse login(CredentialsRequest request) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, request.getEmail(), request.getPhone());
        // Processing
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getEmail(), request.getPassword()));
        String token = JwtUtils.generateToken(customer, request.rememberMe);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.login");
        return new ApiResponse(true, message, Map.of("token", token));
    }
}
