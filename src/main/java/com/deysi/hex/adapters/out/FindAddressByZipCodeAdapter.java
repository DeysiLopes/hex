package com.deysi.hex.adapters.out;

import com.deysi.hex.adapters.out.client.FindAddessByZipCodeClient;
import com.deysi.hex.adapters.out.client.mapper.AddressResponseMapper;
import com.deysi.hex.application.core.domain.Address;
import com.deysi.hex.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddessByZipCodeClient findAddessByZipCodeClient;

    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddessByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
