package com.deysi.hex.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpr;
    @NotBlank
    private String zipCode;
}
