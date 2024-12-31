package com.deysi.hex.config;

import com.deysi.hex.adapters.out.FindAddressByZipCodeAdapter;
import com.deysi.hex.adapters.out.InsertCustomerAdapter;
import com.deysi.hex.application.core.usecase.InsertCustomerUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUsecase insertCustomerUsecase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter){
        return new InsertCustomerUsecase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
