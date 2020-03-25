package com.github.springbootupload;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * @description: 测试copy性能 i5/8g/256固态
 * @author: KL
 * @create: 2020-03-22
 */
public class TestCopy {


    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            IOUtils.closeQuietly(is);
        }
    }


    public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

    public static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, Long.MAX_VALUE);
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    public static void copyFileUsingFileCopyUtils(File source, File dest) throws IOException {
        FileCopyUtils.copy(source,dest);
    }

    public static void main(String[] args) throws Exception{
        File source = new File("d://data/2020_03_22_23_02_26111 (2).zip");
        File dest1 = new File("d://data/1/2020_03_22_23_02_211.zip");
        File dest2 = new File("d://data/2/2020_03_22_23_02_211.zip");
        File dest3 = new File("d://data/3/2020_03_22_23_02_211.zip");
        File dest4 = new File("d://data/4/2020_03_22_23_02_211.zip");
        long start1 = System.nanoTime();
        copyFileUsingStream(source, dest1);
        System.out.println("Time taken by Stream Copy = " + (System.nanoTime() - start1));
        long start2 = System.nanoTime();
        copyFileUsingJava7Files(source, dest2);
        System.out.println("Time taken by Stream Copy = " + (System.nanoTime() - start2));
        long start3 = System.nanoTime();
        copyFileUsingChannel(source, dest3);
        System.out.println("Time taken by Stream Copy = " + (System.nanoTime() - start3));
        long start4 = System.nanoTime();
        copyFileUsingFileCopyUtils(source, dest4);
        System.out.println("Time taken by Stream Copy = " + (System.nanoTime() - start4));
    }

}
