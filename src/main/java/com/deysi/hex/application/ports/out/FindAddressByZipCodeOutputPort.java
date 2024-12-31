package com.deysi.hex.application.ports.out;

import com.deysi.hex.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
