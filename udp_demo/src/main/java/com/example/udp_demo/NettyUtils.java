package com.example.udp_demo;

import io.netty.buffer.ByteBuf;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: KL
 * @Date: 2019/5/8 18:01
 * @Description:
 */
public class NettyUtils {

    private static final String CHARSET_NAME_UTF8 = "UTF-8";

    /**
     *
     * 一个个读取byteBuf中数据转成short类型数组(byte数组有可能益处)
     *
     * 目的:从ByteBuf中读取一定数量的(给定)字节数据,海康威视一般都是作为保留数据
     *
     * @param byteBuf netty字节缓存
     * @return
     */
    public static short[] byteBufToArray(ByteBuf byteBuf) {

        // 判空
        if (byteBuf == null) {
            return null;
        }

        // 字节大小
        int size = byteBuf.readableBytes();
        // 存放结果的数组
        short[] resultArray = new short[size];
        // 循环赋值
        for (int i = 0; i < size; i++) {
            // 读取一个字节放到数组里
            resultArray[i] = byteBuf.readByte();
        }

        // 释放
        byteBuf.release();
        return resultArray;
    }

    /**
     *
     * 读取byteBuf值,根据format并转码
     *
     * @param byteBuf     字节缓存
     * @param charsetName 编码名
     * @return
     */
    public static String byteBufToString(ByteBuf byteBuf, String charsetName) {
        // 判空
        if (byteBuf == null) {
            return null;
        }
        // 编码处理
        if (charsetName == null || "".equals(charsetName)) {
            charsetName = CHARSET_NAME_UTF8;
        }

        // 定义转换目标数组
        byte[] dst = new byte[byteBuf.readableBytes()];
        // 缓冲区放到数组里
        byteBuf.readBytes(dst);

        // 释放
        byteBuf.release();

        // dst去空空值
        byte[] removeDefaultValueArray = removeDefaultValue(dst);

        // 结果
        String result = null;
        try {
            result = new String(removeDefaultValueArray, charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    /**
     *
     * 读取byteBuf值,直接保存字节字符串 例如 : 01 02=>直接保存字符串"0102"
     *
     * 负数不再考虑范围
     *
     * @param byteBuf 字节缓存
     * @return
     */
    public static String byteBufToByteString(ByteBuf byteBuf) {
        // 判空
        if (byteBuf == null) {
            return null;
        }
        // 定义转换目标数组
        byte[] dst = new byte[byteBuf.readableBytes()];
        // 缓冲区放到数组里
        byteBuf.readBytes(dst);

        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        for (byte b : dst) {
            // 判断大小
            if (b <= 9 && b >= 0) {
                // 不足两位补0
                sb.append(0);
            }
            sb.append(b);
        }
        // 释放
        byteBuf.release();
        return sb.toString();
    }

    /**
     *
     * 每次读取两个字节 读取byteBuf值,转10进制数保存list数组中
     *
     * @param byteBuf 字节缓存
     * @return
     */
    public static List<Integer> byteBufToDecimalList(ByteBuf byteBuf) {
        // 判空
        if (byteBuf == null) {
            return null;
        }

        List<Integer> decimalList = new ArrayList<Integer>();

        for (int i = 0; i < byteBuf.readableBytes(); i++) {

            // 每次读取两个字节
            decimalList.add(new Integer(byteBuf.readShort()));
        }

        // 释放
        byteBuf.release();
        return decimalList;
    }

    /**
     *
     * 适用对象:字节数组前半部分连续有效数字,后半部分都是填充的零;只要是字符肯定有编码值不可能是0
     *
     * 目的:获取字符串字节流中有效字节个数,舍弃后面零
     *
     * @param buf
     *
     * @return i 有效个数
     */
    public static int getVirtualValueLength(byte[] buf) {
        // 判空
        if (buf == null) {
            return 0;
        }
        int i = 0;
        for (; i < buf.length; i++) {
            if (buf[i] == (byte) 0) {
                break;
            }
        }
        return i;
    }

    /**
     *
     * 移除默认的值 把旧字节数组的有效数据放到新字节数组
     *
     * @param buf 原始字节数组
     * @return result 处理后的数组
     */
    public static byte[] removeDefaultValue(byte[] buf) {

        // 判空
        if (buf == null) {
            return null;
        }
        // 有效数据长度
        int virtualValueLength = getVirtualValueLength(buf);

        // 新字节数组
        byte[] result = new byte[virtualValueLength];
        // 把旧字节数组的有效数据放到新字节数组
        for (int i = 0; i < virtualValueLength; i++) {
            result[i] = buf[i];
        }
        // 返回
        return result;
    }

    /**
     *
     * Direct Buffer( 直接缓冲区)
     * 直接缓冲区，在堆之外直接分配内存
     * 直接内存是不支持array()方法的
     * 手动转换
     * @param directBuf
     * @return
     */
    public static byte[] directBufferToArray(ByteBuf directBuf) {

        // 判空
        if (directBuf == null) {
            return null;
        }

        int len = directBuf.readableBytes();
        byte[] arr = new byte[len];

        if (!directBuf.hasArray()) {
            directBuf.getBytes(0, arr);
        }

        return arr;
    }

    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            ret += hex;
        }
        return ret;
    }

    public static byte[] hexString2Bytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] = (byte) Integer
                    .valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }

    public static String directBufferToHexString(ByteBuf readBytes) {
        byte[] byteArray=directBufferToArray(readBytes);
        return bytes2HexString(byteArray);
    }
}
