package com.github.fernandocchaves.architecture.customer.application.service;

import com.github.fernandocchaves.architecture.customer.application.rest.dto.response.CustomerResponse;
import com.github.fernandocchaves.architecture.customer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ListAllCustomersService {
    private final CustomerRepository customerRepository;

    public Page<CustomerResponse> execute(Pageable pageable) {
        return customerRepository.findAll(pageable).map(CustomerResponse::new);
    }
}
