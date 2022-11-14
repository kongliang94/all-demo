package com.github.sentineldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flow")
public class FlowControlDemo {


    private static final Integer request = 600;
    @Autowired
    FlowService flowService;


    @GetMapping("/test")
    public void test1(){

        for (Integer i = 0; i < request; i++) {
            new Thread(()->{flowService.test();}).start();
        }

    }
}
