package com.deysi.hex.config;

import com.deysi.hex.adapters.out.FindAddressByZipCodeAdapter;
import com.deysi.hex.adapters.out.UpdateCustomerAdapter;
import com.deysi.hex.application.core.usecase.FindCustomerByIdUsecase;
import com.deysi.hex.application.core.usecase.UpdateCustomerUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUsecase updateCustomerUsecase(
            FindCustomerByIdUsecase findCustomerByIdUsecase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUsecase(findCustomerByIdUsecase,findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
