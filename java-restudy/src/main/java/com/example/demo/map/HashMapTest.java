package com.example.demo.map;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        String keyAa = "Aa";
        String keyBB = "BB";

        System.out.println("keyAa hashCode=" + keyAa.hashCode());
        System.out.println("keyBB hashCode=" + keyBB.hashCode());

        HashMap<String, String> hashMap = new HashMap<String, String>();

        //hashMap.put(keyAa, "abc");//ZF2021203
        //hashMap.put(keyBB, "abc");
        //hashMap.put(keyAa, "cba");
        //ashMap.put(keyAa,"def");
        for (int i = 0; i < 13; i++) {
            hashMap.put(keyAa+i, "abc"+i);
        }

        System.out.println(hashMap);
    }

}
