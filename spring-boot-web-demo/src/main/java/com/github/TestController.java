package com.github;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        log.info("test1");
        log.error("===================================test1===========================================");
        return "test1";
    }
    public String test2(){
        log.info("test2");
        return "test2";
    }
    public String test3(){
        log.info("test3");
        return "test3";
    }
    public String test4(){
        log.info("test4");
        return "test4";
    }
}
