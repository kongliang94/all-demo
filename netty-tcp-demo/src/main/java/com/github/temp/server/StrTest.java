package com.github.temp.server;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @description: 1
 * @author: KL
 * @create: 2020-03-15
 */
public class StrTest {

    public static void main(String[] args) throws Exception{

        String data="JZ12440100012012-11-08 15:45:00001f@@@SO2,0.121,;NO2,0.097,;CO,0.055,;O3,0.102,;雨量,8.9,;风速,10.2,;tek07####";

        /**
         * 30 秒值：
         * 标况：bn01
         * 实况：JR01
         * 5 分钟均值：
         * 标况：JZ12
         * 实况：JR12
         * 1 小时均值：
         * 标况：JZ16
         * 实况：JR16
         * AQI日均值：
         * 标况：JZ18
         * 实况：JR18
         * API日均值：
         * 标况：JZ06
         * 实况：JR06
         * 气象日均值：
         * 标况（无实况）：JZ24
         * 温室气体日均值：
         * 标况（无实况）：JZ25
         */
        String type=data.substring(0,4);
        // 2、 子站编号
        String stationCode=data.substring(4,data.indexOf("@@@")-23);
        // 数据时间点
        String time=data.substring(4+stationCode.length(),data.indexOf("@@@")-4);
        System.out.println(type+":"+stationCode+":"+time);
        String subdata=data.substring(data.indexOf("@@@")+3,data.indexOf("tek"));
        String[] subsque=subdata.split(";");
        for (int i = 0; i < subsque.length; i++) {
            String[] str=subsque[i].split(",");
            System.out.println(str[0]+":"+str[1]);
        }
        System.out.println(subdata);
        trans(data.substring(0,data.indexOf("####")));
    }


    public static void trans(String string) throws Exception{
        byte[] buff = new byte[1024];
        //从字符串获取字节写入流
        InputStream is = new ByteArrayInputStream(string.getBytes("GB2312"));
        System.out.println(is);
        int len=0;
        len = is.read(buff);

        byte b=getXor(buff);
        System.out.println(b);
    }

    public static byte getXor(byte[] data){
        byte temp = 0x00;
        for(int i=0;i<data.length;i++){
            temp^=data[i];
        }
        return temp;
    }
}
