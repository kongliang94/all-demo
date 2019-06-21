package com.example.demo.util;

public class B extends A{
    public int a=10;
    public static int b;

    public B(){
        System.out.println("B 构造"+a);
    }

    public void get(){
        System.out.println("B-get:"+a);
    }
}
