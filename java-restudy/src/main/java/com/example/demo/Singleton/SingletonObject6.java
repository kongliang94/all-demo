package com.example.demo.Singleton;

/**
 * @description: 6
 * @author: KL
 * @create: 2019-08-31
 */
public class SingletonObject6 {

    private SingletonObject6(){
    }
    /**
     * 枚举类型是线程安全的，并且只会装载一次
     */
    private enum Singleton{
        INSTANCE;
        private final SingletonObject6 instance;

        Singleton(){
            instance = new SingletonObject6();
        }

        private SingletonObject6 getInstance(){
            return instance;
        }
    }

    public static SingletonObject6 getInstance(){

        return Singleton.INSTANCE.getInstance();
    }
}

