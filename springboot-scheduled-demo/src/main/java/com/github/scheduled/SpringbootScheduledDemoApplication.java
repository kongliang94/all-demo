package com.github.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootScheduledDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootScheduledDemoApplication.class, args);
    }

}
