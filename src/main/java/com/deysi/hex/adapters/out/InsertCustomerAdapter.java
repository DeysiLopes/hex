package com.deysi.hex.adapters.out;

import com.deysi.hex.adapters.out.repository.CustomerRepository;
import com.deysi.hex.adapters.out.repository.mapper.CustomerEntityMapper;
import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var custumerEntity = customerEntityMapper.toCustomerEntity(customer);
        repository.save(custumerEntity);
    }
}
