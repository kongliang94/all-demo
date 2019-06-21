package com.example.udp_demo;

import com.example.udp_demo.monitor.BleGatewayer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;

@SpringBootApplication
public class UdpDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UdpDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Thread thread=new Thread(new BleGatewayer());
        thread.start();
    }
}
