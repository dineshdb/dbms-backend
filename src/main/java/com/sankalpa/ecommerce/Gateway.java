package com.sankalpa.ecommerce;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class Gateway {

	public static void main(String[] args) {
		//SpringApplication.setWebApplicationType(WebApplicationType.REACTIVE);
		SpringApplication.run(Gateway.class, args);
	}

}
