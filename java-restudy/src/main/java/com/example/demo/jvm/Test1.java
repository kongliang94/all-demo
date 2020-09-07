package com.example.demo.jvm;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {

        System.out.println(String.class.getClassLoader());

        //jdk.internal.loader.ClassLoaders$AppClassLoader
        System.out.println(Test1.class.getClassLoader());
    }
}
