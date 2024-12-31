package com.deysi.hex.application.ports.out;

import com.deysi.hex.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
