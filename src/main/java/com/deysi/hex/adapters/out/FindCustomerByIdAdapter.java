package com.deysi.hex.adapters.out;

import com.deysi.hex.adapters.out.repository.CustomerRepository;
import com.deysi.hex.adapters.out.repository.mapper.CustomerEntityMapper;
import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
