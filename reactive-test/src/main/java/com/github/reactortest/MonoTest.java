package com.github.reactortest;

import lombok.Data;
import reactor.core.publisher.Mono;


public class MonoTest {
    public static void main(String[] args) {
        mono();
    }

    public static void mono(){

        Mono mono=Mono.create(monoSink -> {
            monoSink.success("hello");
        });

        mono.subscribe(System.out::println);
    }
}

@Data
class User{
    private String name;
}
