package com.demo.webfluxbase;

import org.springframework.boot.SpringApplication;

public class TestWebFluxBaseApplication {

    public static void main(String[] args) {
        SpringApplication.from(WebFluxBaseApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
