package com.example.demo.BaseTest;

public class StringTest {
    public static void main(String[] args) {
        String str1="hello";
        String str2=new String("hello");
        System.out.println(str1.hashCode()+" "+str2.hashCode());
        System.out.println(str1==str2);
    }
}
