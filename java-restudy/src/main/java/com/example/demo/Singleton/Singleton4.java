package com.example.demo.Singleton;

public class Singleton4 {

    // volatile禁止指令重排序
    private volatile static Singleton4 instance = null;

    private Singleton4() {}

    public static Singleton4 getInstance() {

        // 双重检测单例模式
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();    //创建实例
                }
            }
        }
        return instance;
    }
}
