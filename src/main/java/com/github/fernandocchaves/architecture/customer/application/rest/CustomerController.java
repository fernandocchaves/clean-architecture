package com.github.fernandocchaves.architecture.customer.application.rest;

import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.CreateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.UpdateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.response.CustomerResponse;
import com.github.fernandocchaves.architecture.customer.application.rest.swagger.api.CustomerApi;
import com.github.fernandocchaves.architecture.customer.application.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/customers")
@RestController
@Slf4j
public class CustomerController implements CustomerApi {
    private final CreateCustomerService createCustomerService;
    private final ShowCustomerService showCustomerService;
    private final ListAllCustomersService listAllCustomersService;
    private final UpdateCustomerService updateCustomerService;
    private final DeleteCustomerService deleteCustomerService;

    @PostMapping
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody @Valid CreateCustomerRequest customerRequest) {
        return createCustomerService.execute(customerRequest);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CustomerResponse findById(@PathVariable Long id) {
        return showCustomerService.execute(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CustomerResponse> findAll(Pageable pageable) {
        return listAllCustomersService.execute(pageable);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public CustomerResponse update(@PathVariable Long id,
                                   @RequestBody UpdateCustomerRequest request) {
        return updateCustomerService.execute(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteCustomerService.execute(id);
    }
}