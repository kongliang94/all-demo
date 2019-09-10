package com.example.demo.BaseTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 1
 * @author: KL
 * @create: 2019-09-02
 */
public class ShortSet {
    public static void main(String args[]) {

        Set s=new HashSet();

        for(Short i=0;i<100;i++) {

            s.add(i);
            System.out.println(i-1);

            s.remove(i-1);

        }



        System.out.println(s.size());

    }
}
