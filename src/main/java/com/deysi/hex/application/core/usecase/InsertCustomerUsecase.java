package com.deysi.hex.application.core.usecase;

import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.in.InsertCustomerInputPort;
import com.deysi.hex.application.ports.out.FindAddressByZipCodeOutputPort;
import com.deysi.hex.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUsecase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUsecase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);

        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
    }
}
