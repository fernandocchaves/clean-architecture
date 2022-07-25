package com.github.fernandocchaves.architecture.customer.application.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.fernandocchaves.architecture.customer.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class AddressResponse {
    @JsonIgnore
    private Address address;

    public String getAddress1() {
        return address.getAddress1();
    }

    public String getAddress2() {
        return address.getAddress2();
    }

    public String getNumber() {
        return address.getNumber();
    }

    public String getNeighborhood() {
        return address.getNeighborhood();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getState() {
        return address.getState();
    }

    public String getZipCode() {
        return address.getZipCode();
    }
}
