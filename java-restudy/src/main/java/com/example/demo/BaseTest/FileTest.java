package com.example.demo.BaseTest;

import java.io.File;

/**
 * @description: 11
 * @author: KL
 * @create: 2020-06-24
 */
public class FileTest {

    public static void main(String[] args) {
        File file22=new File("d:/tset");
        if (!file22.exists()){
            file22.mkdir();
        }
        File file1=new File(new File("d:\\data"),"kr.txt");
        if (file1.exists()){
            System.out.println(file1.getAbsoluteFile());
        }else {
            System.out.println(file1.getName());
        }
        File file = new File("D:/data/kr.txt");

        File file2 = new File("D:/test/异常1.jpg");

        File file3 = new File("xxx"); // 错误路径

        System.out.println(file.exists()); // 结果是true

        System.out.println(file2.exists()); // 结果是true

        System.out.println(file3.exists()); // 结果是false

    }
}
