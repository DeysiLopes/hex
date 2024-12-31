package com.deysi.hex.application.core.usecase;

import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.in.FindCustomerByIdInputPort;
import com.deysi.hex.application.ports.in.UpdateCustomerInputPort;
import com.deysi.hex.application.ports.out.FindAddressByZipCodeOutputPort;
import com.deysi.hex.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUsecase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUsecase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
