package com.deysi.hex.adapters.out;

import com.deysi.hex.adapters.out.repository.CustomerRepository;
import com.deysi.hex.application.ports.out.DeleteCustomerByIdOuputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOuputPort {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
