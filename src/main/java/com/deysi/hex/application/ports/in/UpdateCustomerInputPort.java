package com.deysi.hex.application.ports.in;

import com.deysi.hex.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
