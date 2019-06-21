package com.example.demo.util;

public class LazyTest {
    public static void main(String[] args) {

        var z = Lazy.let( () -> "Hello" );
        System.out.println(z.get());
    }
}
