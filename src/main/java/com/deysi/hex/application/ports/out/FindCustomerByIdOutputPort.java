package com.deysi.hex.application.ports.out;

import com.deysi.hex.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
