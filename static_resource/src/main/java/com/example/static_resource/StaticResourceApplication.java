package com.example.static_resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@SpringBootApplication
public class StaticResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaticResourceApplication.class, args);
    }

}

@RestController
class TestController{

    @GetMapping("test")
    public static  String  getUrl() {
        String path = null;
        try {
            String serverpath= ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\');
            path=serverpath.substring(1);//从路径字符串中取出工程路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return path;
    }
}