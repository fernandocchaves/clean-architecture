package com.github.fernandocchaves.architecture.customer.application.service;

import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.CreateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.UpdateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.response.CustomerResponse;
import com.github.fernandocchaves.architecture.customer.domain.Address;
import com.github.fernandocchaves.architecture.customer.domain.Customer;
import com.github.fernandocchaves.architecture.customer.domain.repository.AddressRepository;
import com.github.fernandocchaves.architecture.customer.domain.repository.CustomerRepository;
import com.github.fernandocchaves.architecture.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UpdateCustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerResponse execute(Long id, UpdateCustomerRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        Address address = addressRepository.findById(customer.getAddress().getId())
                .orElseThrow(ResourceNotFoundException::new);

        customer.setName(request.getName());
        customer.setDocument(request.getDocument());
        customer.setEmail(request.getEmail());
        customer.setCellphone(request.getCellphone());
        customer.setPhone(request.getPhone());

        address.setAddress1(request.getAddress().getAddress1());
        address.setAddress2(request.getAddress().getAddress2());
        address.setNumber(request.getAddress().getNumber());
        address.setNeighborhood(request.getAddress().getNeighborhood());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getCity());
        address.setZipCode(request.getAddress().getZipCode());

        customerRepository.save(customer);
        addressRepository.save(address);

        return new CustomerResponse(customer);
    }
}
