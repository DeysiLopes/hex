package com.deysi.hex.adapters.in.consumer.mapper;

import com.deysi.hex.adapters.in.consumer.message.CustomerMessage;
import com.deysi.hex.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMassageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
