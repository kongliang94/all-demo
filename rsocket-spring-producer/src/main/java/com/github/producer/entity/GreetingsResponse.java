package com.github.producer.entity;

import lombok.Data;

import java.time.Instant;

@Data
public class GreetingsResponse {

    private String greeting;

    public GreetingsResponse(){

    }

    public GreetingsResponse(String name){
        this.withGreeting("Hello " + name + " @ " + Instant.now());
    }

    public GreetingsResponse withGreeting(String msg) {
        this.greeting = msg;
        return this;
    }
}
