package com.deysi.hex.adapters.out.client;

import com.deysi.hex.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name= "FindAddessByZipCodeClient",
        url= "${deysi.client.address.url}"
)
public interface FindAddessByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipCode);

}
