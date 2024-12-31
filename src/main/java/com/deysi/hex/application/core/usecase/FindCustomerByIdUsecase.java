package com.deysi.hex.application.core.usecase;

import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.in.FindCustomerByIdInputPort;
import com.deysi.hex.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUsecase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUsecase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
