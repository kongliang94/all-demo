package com.example.demo.util;

public class LazyTest {
    public static void main(String[] args) {

        Lazy let = Lazy.let(() -> "Hello");
        System.out.println(let.get());
    }
}
