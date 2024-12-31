package com.deysi.hex.application.core.usecase;

import com.deysi.hex.application.ports.in.DeleteCustomerByIdInputPort;
import com.deysi.hex.application.ports.in.FindCustomerByIdInputPort;
import com.deysi.hex.application.ports.out.DeleteCustomerByIdOuputPort;

public class DeleteCustomerByIdUsecase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOuputPort deleteCustomerByIdOuputPort;

    public DeleteCustomerByIdUsecase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOuputPort deleteCustomerByIdOuputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOuputPort = deleteCustomerByIdOuputPort;
    }

    @Override
    public void delete(String id){
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOuputPort.delete(id);
    }
}
