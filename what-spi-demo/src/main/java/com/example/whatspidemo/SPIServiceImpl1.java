package com.example.whatspidemo;

public class SPIServiceImpl1 implements SPIService{

    private String name="SPIServiceImpl1";
    @Override
    public void execute() {
        System.out.println("spi impl one");
    }

    @Override
    public String getName() {
       return this.name;
    }
}
