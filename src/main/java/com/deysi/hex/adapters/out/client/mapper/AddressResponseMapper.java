package com.deysi.hex.adapters.out.client.mapper;

import com.deysi.hex.adapters.out.client.response.AddressResponse;
import com.deysi.hex.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address  toAddress(AddressResponse addressResponse);
}
