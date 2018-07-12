package com.sankalpa.ictc_events;

import com.sankalpa.ictc_events.repository.AdminRepository;
import org.springframework.boot.*;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
//@EnableWebMvc
@SpringBootApplication
public class Gateway /*implements WebMvcConfigurer*/ {

	public static void main(String[] args) {
		//SpringApplication.setWebApplicationType(WebApplicationType.REACTIVE);
		SpringApplication.run(Gateway.class, args);
	}
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//	}
}
