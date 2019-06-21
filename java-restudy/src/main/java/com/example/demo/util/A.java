package com.example.demo.util;

public class A {
    public int a;
    public static int b;

    public A(){
        System.out.println(" A构造:"+a+" start");
        get();
        System.out.println(" A构造:"+a+" end");
    }

    public void get(){
        System.out.println("A-get: "+a);
    }
}
