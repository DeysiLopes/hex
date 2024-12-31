package com.deysi.hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HexApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexApplication.class, args);
	}

}
