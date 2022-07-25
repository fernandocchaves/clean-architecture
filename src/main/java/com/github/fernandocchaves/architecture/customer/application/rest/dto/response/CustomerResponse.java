package com.github.fernandocchaves.architecture.customer.application.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.fernandocchaves.architecture.customer.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CustomerResponse {

    @JsonIgnore
    private Customer customer;

    public Long getId() {
        return customer.getId();
    }

    public String getName() {
        return customer.getName();
    }

    public String getDocument() {
        return customer.getDocument();
    }

    public AddressResponse getAddress() {
        return new AddressResponse(customer.getAddress());
    }

}
