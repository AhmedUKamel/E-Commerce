package org.ahmedukamel.ecommerce.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.AddressDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.mapper.AddressMapper;
import org.ahmedukamel.ecommerce.model.Address;
import org.ahmedukamel.ecommerce.model.Customer;
import org.ahmedukamel.ecommerce.repository.CustomerRepository;
import org.ahmedukamel.ecommerce.service.AddressService;
import org.ahmedukamel.ecommerce.util.MessageSourceUtils;
import org.ahmedukamel.ecommerce.util.RepositoryUtils;
import org.ahmedukamel.ecommerce.util.SecurityContextUtils;
import org.ahmedukamel.ecommerce.util.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {
    private final CustomerRepository customerRepository;
    private final MessageSourceUtils messageSourceUtils;

    @Override
    public ApiResponse addAddress(AddressDto request) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        // Validating
        ValidationUtils.validateAddressesNumber(customer, messageSourceUtils);
        // Processing
        Address address = AddressMapper.fromResponse(request);
        address.setCustomer(customer);
        customer.getAddresses().add(address);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.add.address");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse deleteAddress(Integer addressId) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        // Validating
        Address address = ValidationUtils.validateGetCustomerAddress(customer, addressId, messageSourceUtils);
        ValidationUtils.validateActiveAddress(address);
        // Processing
        address.setActive(false);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.delete.address");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse getAddresses() {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        // Processing
        List<Address> activeAdds = customer.getAddresses().stream().filter(Address::getActive).toList();
        List<AddressDto> addressResponseList = AddressMapper.toResponse(activeAdds);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.get.address");
        return new ApiResponse(true, message, Map.of("addresses", addressResponseList));
    }
}