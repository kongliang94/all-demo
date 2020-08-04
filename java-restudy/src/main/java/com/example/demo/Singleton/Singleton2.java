package com.example.demo.Singleton;

public class Singleton2 {

    private Singleton2(){

    }

    // 声明为 private 表明静态内部该类只能在该 Singleton 类中被访问
    private static class Singleton2Instance{
        private static final Singleton2 INSTANCE= new Singleton2();
    }

    public static Singleton2 getInstance(){
        return Singleton2Instance.INSTANCE;
    }

}
