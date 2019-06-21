package com.example.udp_demo.monitor;

import lombok.Data;

@Data
public class ParkingLockInfo {
    /** 车位锁状态 1 */
    private int lockStatus;
    /** 是否有车 1 */
    private int carStatus;
    /** 电量 1 */
    private int batteryLevel;

    private  String macAddr;
}
