package com.example.udp_demo;

/**
 * @Auther: KL
 * @Date: 2019/5/8 18:39
 * @Description:
 */
public class Constants {
    /**
     * 网关心跳包
     */
    public final static String GATEWAY_HEART="01";
    /**
     * 网关扫描配置回复
     */
    public final static String GATEWAY_SCAN_CALLBACK="02";
    /**
     * 说明：
     * 当扫描模式X==0 ：设备停止扫描，不上报数据
     * 当扫描模式X==1 ：设备单次扫描，且扫描Ys后上报数据，停止扫描。
     * 当扫描模式X==2 ：设备持续扫描，并每间隔Ys上报一次扫描所得数据。
     *
     * 默认: X=0,Y=0.
     */
    public final static String GATEWAY_SCAN="20";
    /**
     * 网关回复广播数据查询
     */
    public final static String GATEWAY_REPLY_BROADCAST_DATA_QUERY="03";
    /**
     * 连接结果说明：
     * x=0x00  ：连接成功
     * x=0x01  ：连接失败
     * x=0x02  ：该蓝牙正在连接中，请稍后。
     * X=0x03  ：蓝牙连接已达上限请先断开部分蓝牙。
     */
    public final static String GATEWAY_UPLOAD_CONNECTION_CALLBACK="04";
    /**
     * 网关接受连接指令
     */
    public final static String GATEWAY_ACCEPTS_CONNECTION="40";
    /**
     * 网关上传断开连接指令回复
     */
    public final static String GATEWAY_UPLOAD_DISCONNECT_CALLBACK="05";
    /**
     * 网关接受断开连接指令
     */
    public final static String GATEWAY_UPLOAD_DISCONNECT_COMMAND="50";
    /**
     * 网关发送透传数据结果回复
     */
    public final static String GATEWAY_SEND_TRANSPARENT_DATA_CALLBACK="06";
    /**
     * 网关接受透传数据并向目标设备发送
     */
    public final static String GATEWAY_ACCEPTSTRANSPARENTDATA_SENDTOTARGET="60";
    /**
     * 网关回复指令错误
     */
    public final static String GATEWAY_RELPY_ERROR="FF";

    public final static String CONNECT="ADBA000140000FEA864086DAA200FE";
}
