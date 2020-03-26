package com.example.whatspidemo;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {

        ServiceLoader<SPIService> loader = ServiceLoader.load(SPIService.class);
        for (SPIService s:loader) {
            if (s.getName().contains("2")){
                s.execute();
            }
            //s.execute();
        }
    }
}
