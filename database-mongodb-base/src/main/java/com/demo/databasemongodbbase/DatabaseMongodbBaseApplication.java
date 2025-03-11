package com.demo.databasemongodbbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EntityScan("com.demo.databasemongodbbase.model")
public class DatabaseMongodbBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseMongodbBaseApplication.class, args);
	}

}
