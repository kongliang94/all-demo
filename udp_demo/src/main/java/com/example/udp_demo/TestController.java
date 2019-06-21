package com.example.udp_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;

@RestController
@RequestMapping("/kl")
public class TestController{
    @GetMapping("/test")
    public String test(){


        return "SUCCESS";
    }
}
