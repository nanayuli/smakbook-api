package com.smakbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SmakbookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmakbookApiApplication.class, args);
	}

}
