package com.github.fernandocchaves.architecture.customer.application.rest.dto.request;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CreateCustomerRequest {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String document;

    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    private String cellphone;

    private String phone;

    @NotNull
    @Valid
    private AddressRequest address;
}