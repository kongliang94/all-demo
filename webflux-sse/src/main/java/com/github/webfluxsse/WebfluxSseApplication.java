package com.github.webfluxsse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebfluxSseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxSseApplication.class, args);
	}

}
