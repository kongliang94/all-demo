package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
            list.add(String.valueOf(i++).intern());
            list.add(String.valueOf(i++).intern());
        }
    }
}
