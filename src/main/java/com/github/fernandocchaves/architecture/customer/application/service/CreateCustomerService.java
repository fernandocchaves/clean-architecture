package com.github.fernandocchaves.architecture.customer.application.service;

import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.AddressRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.CreateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.response.CustomerResponse;
import com.github.fernandocchaves.architecture.customer.domain.Address;
import com.github.fernandocchaves.architecture.customer.domain.Customer;
import com.github.fernandocchaves.architecture.customer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CreateCustomerService {
    private final CustomerRepository customerRepository;

    public CustomerResponse execute(CreateCustomerRequest request) {
        Address address = Address.builder()
                .address1(request.getAddress().getAddress1())
                .address2(request.getAddress().getAddress2())
                .number(request.getAddress().getNumber())
                .neighborhood(request.getAddress().getNeighborhood())
                .city(request.getAddress().getCity())
                .state(request.getAddress().getState())
                .zipCode(request.getAddress().getZipCode())
                .build();

        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .document(request.getDocument())
                .cellphone(request.getCellphone())
                .phone(request.getPhone())
                .address(address)
                .build();

        customerRepository.save(customer);
        return new CustomerResponse(customer);
    }

}
