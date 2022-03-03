package com.bootcamp.calatologcurrencyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@EnableReactiveMongoAuditing
@SpringBootApplication
public class CalatologcurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalatologcurrencyServiceApplication.class, args);
	}

}
