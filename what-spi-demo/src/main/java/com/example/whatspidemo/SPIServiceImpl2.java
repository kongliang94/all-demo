package com.example.whatspidemo;

public class SPIServiceImpl2 implements SPIService{

    private String name="SPIServiceImpl2";

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void execute() {
        System.out.println("spi impl two");
    }
}
