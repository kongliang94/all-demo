package com.example.demo.util;

public class Test1 {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);   //flase
        String temp=s.intern();
        System.out.println(temp == s2);   //true

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);   //true

        final String a = "hello";
        String b = "hello";
        final String c = "world";
        String d = "hello" + "world";
        String e = a + c;
        String f = b + c;
        String g = "helloworld";
        System.out.println(g == d);//true
        System.out.println(g == e);//true
        System.out.println(a == b);//true
        System.out.println(g == f);//false
        String string1 = "hello";
        String string2 = "world";
        String string4="helloworld";
        String string3 = string1+string2;
        System.out.println(string3 == string4);//false

    }
}
