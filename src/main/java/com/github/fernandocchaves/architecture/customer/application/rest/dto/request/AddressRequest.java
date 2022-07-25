package com.github.fernandocchaves.architecture.customer.application.rest.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    @NotBlank
    @Size(max = 150)
    private String address1;

    private String address2;

    private String number;

    @NotBlank
    @Size(max = 100)
    private String neighborhood;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    @Size(max = 100)
    private String state;

    @NotBlank
    @Size(max = 10)
    private String zipCode;
}
