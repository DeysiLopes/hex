package com.deysi.hex.adapters.in.consumer;

import com.deysi.hex.adapters.in.consumer.mapper.CustomerMassageMapper;
import com.deysi.hex.adapters.in.consumer.message.CustomerMessage;
import com.deysi.hex.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidateCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMassageMapper customerMassageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "deysi")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMassageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
