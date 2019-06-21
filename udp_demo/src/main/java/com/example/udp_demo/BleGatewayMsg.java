package com.example.udp_demo;

import com.example.udp_demo.monitor.ParkingLockInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BleGatewayMsg {
    //包头
    private String header;
    //协议版本号
    private String version;
    //数据类型
    private String dataType;
    //数据包总长度
    private String dataLength;
    //网关MAC地址
    private String gatewayMac;
    //蓝牙设备MAC地址
    private String deviceMac;
    //下发蓝牙设备指令的回调结果
    private String result;
    //下发指令内容
    private String content;

    private List<ParkingLockInfo> parkingLockInfos;
    //预留字段
    private String reservedField;
    //校验值
    private String checkValue;
    //包尾
    private String tail;
}
