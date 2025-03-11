package com.demo.webfluxdatabse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class WebfluxDatabseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDatabseApplication.class, args);
	}

}
