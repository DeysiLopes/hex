package com.deysi.hex.adapters.in.controller.mapper;

import com.deysi.hex.adapters.in.controller.request.CustomerRequest;
import com.deysi.hex.adapters.in.controller.response.CustomerResponse;
import com.deysi.hex.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    Customer toCostumer(CustomerRequest customerRequest);
    CustomerResponse toCustomerResponse(Customer customer);
}
