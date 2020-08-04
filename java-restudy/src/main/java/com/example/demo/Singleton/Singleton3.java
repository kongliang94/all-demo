package com.example.demo.Singleton;

public class Singleton3 {

    private static Singleton3 instance = null;
    private Singleton3() {}

    public static synchronized Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();    //创建实例
        }
        return instance;
    }

}
