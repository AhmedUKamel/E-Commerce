package org.ahmedukamel.ecommerce.mapper;

import org.ahmedukamel.ecommerce.dto.CustomerDto;
import org.ahmedukamel.ecommerce.dto.request.CredentialsRequest;
import org.ahmedukamel.ecommerce.model.Customer;
import org.ahmedukamel.ecommerce.model.CustomerDetail;
import org.ahmedukamel.ecommerce.model.Role;
import org.ahmedukamel.ecommerce.util.EntityDetailsUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

public class CustomerMapper {
    public static CustomerDto toResponse(Customer customer, Integer languageId) {
        CustomerDetail customerDetail = EntityDetailsUtils.supplyCustomerDetail(customer, languageId);
        CustomerDto response = new CustomerDto();
        response.setCustomerId(customer.getCustomerId());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        response.setFirstName(customerDetail.getFirstName());
        response.setLastName(customerDetail.getLastName());
        response.setRole(customer.getRole().name());
        response.setEnabled(customer.getEnabled());
        return response;
    }

    public static List<CustomerDto> toResponse(Collection<Customer> items, Integer languageId) {
        return items.stream().map(item -> CustomerMapper.toResponse(item, languageId)).toList();
    }

    public static Customer toCustomer(PasswordEncoder passwordEncoder, CredentialsRequest request) {
        Customer customer = new Customer();
        customer.setEmail(request.getEmail().toLowerCase().strip());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customer.setPhone(request.getPhone().strip());
        customer.setRole(Role.CUSTOMER);
        customer.setEnabled(true);
        return customer;
    }
}
