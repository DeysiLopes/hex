package com.deysi.hex.adapters.in.controller;

import com.deysi.hex.adapters.in.controller.mapper.CustomerMapper;
import com.deysi.hex.adapters.in.controller.request.CustomerRequest;
import com.deysi.hex.adapters.in.controller.response.CustomerResponse;
import com.deysi.hex.application.core.domain.Customer;
import com.deysi.hex.application.ports.in.DeleteCustomerByIdInputPort;
import com.deysi.hex.application.ports.in.FindCustomerByIdInputPort;
import com.deysi.hex.application.ports.in.InsertCustomerInputPort;
import com.deysi.hex.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;



    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        System.out.println("Recebendo requisição: " + customerRequest);
        var customer = customerMapper.toCostumer(customerRequest);
        System.out.println("Cliente antes do insert: " + customer);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        System.out.println("Cliente processado: " + customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer =findCustomerByIdInputPort.find(id);
        var customerResponse =customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCostumer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
