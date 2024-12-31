package com.deysi.hex.application.core.usecase;

import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.in.InsertCustomerInputPort;
import com.deysi.hex.application.ports.out.FindAddressByZipCodeOutputPort;
import com.deysi.hex.application.ports.out.InsertCustomerOutputPort;
import com.deysi.hex.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUsecase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUsecase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort
    ) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        var address = findAddressByZipCodeOutputPort.find(zipCode);

        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
