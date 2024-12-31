package com.deysi.hex.adapters.out;

import com.deysi.hex.adapters.out.repository.CustomerRepository;
import com.deysi.hex.adapters.out.repository.mapper.CustomerEntityMapper;
import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
