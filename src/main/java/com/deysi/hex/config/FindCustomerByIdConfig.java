package com.deysi.hex.config;

import com.deysi.hex.adapters.out.FindCustomerByIdAdapter;
import com.deysi.hex.application.core.usecase.FindCustomerByIdUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUsecase findCustomerByIdUsecase(FindCustomerByIdAdapter findCustomerByIdAdapter){
        return new FindCustomerByIdUsecase(findCustomerByIdAdapter);
    }

}
