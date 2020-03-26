package com.github.springbootshirodemo.common.properties;

public class TestProperties {
    public static void main(String[] args) {
        ServerProperties serverProperties=new ServerProperties();
        System.out.println(serverProperties.getAccessTokenExpireTime());
    }
}
