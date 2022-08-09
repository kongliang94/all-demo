package com.example.springbootkettledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootKettleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKettleDemoApplication.class, args);
	}

}
