package com.github.springbootupload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 文件上传下载
 * @author: KL
 * @create: 2020-03-22
 */
@RestController
public class FileController {

    @PostMapping("/upload1")
    public String upload1(@RequestParam("file") MultipartFile file) throws IOException {
        long start1 = System.nanoTime();


        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        // 新文件名
        DateFormat dateTimeformat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String newFileName = dateTimeformat.format(new Date())+fileName.replaceAll(" ", "");

        String path = "D://data/9/";
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            file.transferTo(new File(path + newFileName));
        }
        System.out.println("Time taken by Stream Copy1 = " + (System.nanoTime() - start1));
        return "success";

    }
    @PostMapping("/upload2")
    public String upload2(@RequestParam("file") MultipartFile file) throws IOException {
        long start1 = System.nanoTime();

        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        // 新文件名
        DateFormat dateTimeformat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String newFileName = dateTimeformat.format(new Date())+fileName.replaceAll(" ", "");
        // 上传位置
        String path = "D://data/6/";
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            //start
            FileInputStream in = (FileInputStream) file.getInputStream();
            FileOutputStream out =  new FileOutputStream(new File(path + newFileName));
            try {
                FileChannel fcIn = in.getChannel();
                FileChannel fcOut = out.getChannel();
               fcOut.transferFrom(fcIn,0,Long.MAX_VALUE);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                in.close();
                out.close();
            }
            //end
        }
        System.out.println("Time taken by Stream Copy2 = " + (System.nanoTime() - start1));
        return "success";

    }
}
