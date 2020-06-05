package com.example.demo.BaseTest;

/**
 *  测试Integer最大值+1 等于啥？？？
 */
public class IntegerTest {

    private static final int END = Integer.MAX_VALUE;
    private static final int START = END - 100;

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        int count = 0;
        for (int i = START; i <= END; i++) {
            count++;
        }
        // i <= END永远为true ，所以下面不会打印
        System.out.println(count);
    }

}
