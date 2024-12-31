package com.deysi.hex.config;

import com.deysi.hex.adapters.out.DeleteCustomerByIdAdapter;
import com.deysi.hex.application.core.usecase.DeleteCustomerByIdUsecase;
import com.deysi.hex.application.core.usecase.FindCustomerByIdUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUsecase deleteCustomerByIdUsecase(
            FindCustomerByIdUsecase findCustomerByIdUsecase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUsecase(findCustomerByIdUsecase, deleteCustomerByIdAdapter);
    }
}
