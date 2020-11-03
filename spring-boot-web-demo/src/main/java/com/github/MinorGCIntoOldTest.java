package com.github;

public class MinorGCIntoOldTest {
    /**
     * 新生代10M 8:1:1 老年代10M
     * <p>
     * -XX:NewSize=10M -XX:MaxNewSize=10M -Xms20M -Xmx20M -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails
     * -XX:+PrintGCTimeStamps -Xloggc:logs/gc.log
     * -XX:+PrintTenuringDistribution
     *
     * @param args
     */
    public static void main(String[] args) {

        byte[] array_transfer1 = new byte[1024 * 1024];
        byte[] array_transfer2 = new byte[2*1024 * 1024];
        byte[] array_transfer3 = new byte[256 * 1024];
        for (int i = 0; i < 50; i++) {
            byte[] array01 = new byte[4 * 1024 * 1024];
            array01 = new byte[4 * 1024 * 1024];
            //array01=null;
            byte[] array02 = new byte[128 * 1024];
            array02=null;
        }
        System.out.println(array_transfer1);


    }
}
