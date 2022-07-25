package com.github.fernandocchaves.architecture.customer.application.service;

import com.github.fernandocchaves.architecture.customer.application.rest.dto.response.CustomerResponse;
import com.github.fernandocchaves.architecture.customer.domain.Customer;
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
public class ShowCustomerService {
    private final CustomerRepository customerRepository;

    public CustomerResponse execute(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return new CustomerResponse(customer);
    }

}
