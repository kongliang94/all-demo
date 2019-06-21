package com.example.udp_demo;

public class Constants {
	/** id */
	public static final String ID = "id";

	/** 编号 */
	public static final String NUMBER = "number";

	/** 名称 */
	public static final String NAME = "name";

	/** 地址 */
	public static final String ADDRESS = "address";

	/** 状态 */
	public static final String STATUS = "status";

	/** 小区名称 */
	public static final String VILLAGENAME = "villageName";
	/** 主服务器域名 */
	public static final String DAXIANG_MASTER_SERVER = "https://daxiangpark.cn/appservice";
	//public static final String DAXIANG_MASTER_SERVER = "https://daxiang-ip.com";
	//public static final String PISSERVER = "http://daxiangshare.com/PIS/";
	//public static final String PISSERVER = "http://daxiang-ip.com/PIS/";
	/** PMS系统地址 */
	public static final String PMSSERVER = "";

	/** 物业openID标识 */
	public static final String PMSOPENID = "wy";

	/** 初始化密码 : 00000000 */
	public static final String INIT_PASSWORD = "00000000";

	/** 监听2号redis中key过期事件  */
	public static final String KEY_EVENT_EXPIRED_2 = "__keyevent@2__:expired";

	// 数组大小
	/** 数组大小:1 */
	public static final int ARRAY_SIZE_1 = 1;
	/** 数组大小:2 */
	public static final int ARRAY_SIZE_2 = 2;
	/** 数组大小:3 */
	public static final int ARRAY_SIZE_3 = 3;
	/** 数组大小:4 */
	public static final int ARRAY_SIZE_4 = 4;
	/** 数组大小:6 */
	public static final int ARRAY_SIZE_6 = 6;
	/** 数组大小:8 */
	public static final int ARRAY_SIZE_8 = 8;
	/** 数组大小:12 */
	public static final int ARRAY_SIZE_12 = 12;
	/** 数组大小:16 */
	public static final int ARRAY_SIZE_16 = 16;
	/** 数组大小:20 */
	public static final int ARRAY_SIZE_20 = 20;
	/** 数组大小:24 */
	public static final int ARRAY_SIZE_24 = 24;
	/** 数组大小:30 */
	public static final int ARRAY_SIZE_30 = 30;
	/** 数组大小:32 */
	public static final int ARRAY_SIZE_32 = 32;
	/** 数组大小:35 */
	public static final int ARRAY_SIZE_35 = 35;
	/** 数组大小:48 */
	public static final int ARRAY_SIZE_48 = 48;
	/** 数组大小:64 */
	public static final int ARRAY_SIZE_64 = 64;

	/** 字符编码名称:UTF-8 */
	public static final String CHARSET_NAME_UTF_8 = "UTF-8";
	/** 字符编码名称:GBK */
	public static final String CHARSET_NAME_GBK = "GBK";

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

	//信息头
	public final static String HEADER="ADBA";
	//协议版本号
	public final static String VERSION="0001";
	//数据类型(多种)
	public final static String dataType="";
	//包尾
	public final static String TAIL="FE";

	//下发开锁指令的信息包的头部
	public final static String BLE_ACC_HEADER="10";

	//开关锁指令
	public final static String BLE_ACC_CLOSE="00";
	public final static String BLE_ACC_OPEN="01";
	public final static String BLE_ACC_FORCEOPEN="02";
	public final static String BLE_ACC_OPENULTRASONIC="03";


	//开锁指令数据长度10 0000000001
	public static final String BLE_ACC_COMMAND_LENGTH = "0006";
	//连接网关指令长度
    public static final String GATEWAY_ACCEPTS_CONNECTION_LENGTH = "000F";
    //开锁指令长度
    public static final String GATEWAY_ACCEPTSTRANSPARENTDATA_LENGTH = "0017";
    //断开连接指令长短
    public static final String GATEWAY_DISCONNECT_LENGTH = "000F";
    //扫描指令长度
    public static final String GATEWAY_SCAN_LENGTH = "000B";
    //指令错误
    public static final String GATEWAY_COMMAND_ERROR = "FF";
}
