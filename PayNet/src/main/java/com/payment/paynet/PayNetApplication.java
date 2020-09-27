package com.payment.paynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PayNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayNetApplication.class, args);
	}

}
