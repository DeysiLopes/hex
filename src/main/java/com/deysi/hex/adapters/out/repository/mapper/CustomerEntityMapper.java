package com.deysi.hex.adapters.out.repository.mapper;

import com.deysi.hex.adapters.out.repository.entity.CustomerEntity;
import com.deysi.hex.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity (Customer customer);
    Customer toCustomer (CustomerEntity customerEntity);
}
