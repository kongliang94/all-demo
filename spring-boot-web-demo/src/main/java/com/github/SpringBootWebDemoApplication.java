package com.github;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebDemoApplication.class, args);
    }

}

@RestController
class TestController{

    private FormatTemplate formatTemplate;

    TestController(FormatTemplate formatTemplate) {
        this.formatTemplate = formatTemplate;
    }

    @GetMapping("/test")
    public String formatTest(){

        return formatTemplate.doFormat(User.builder().id("1").name("ll").build());
    }
}

@Data
@Builder
class User{
    private String id;
    private String name;
}