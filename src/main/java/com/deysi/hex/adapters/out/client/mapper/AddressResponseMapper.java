package com.deysi.hex.adapters.out.client.mapper;

import com.deysi.hex.adapters.out.client.response.AddressResponse;
import com.deysi.hex.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    @Mapping(target = "street", source = "addressResponse.street")
    @Mapping(target = "city", source = "addressResponse.city")
    @Mapping(target = "state", source = "addressResponse.state")
    Address  toAddress(AddressResponse addressResponse);
}
