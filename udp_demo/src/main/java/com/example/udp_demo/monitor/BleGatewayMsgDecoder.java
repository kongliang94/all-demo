package com.example.udp_demo.monitor;

import com.example.udp_demo.BleGatewayMsg;
import com.example.udp_demo.BleGatewayProtocolDecoder;
import com.example.udp_demo.Constants;
import com.example.udp_demo.NettyUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 *功能描述  udp的监听者的解码器(相当于server端接受数据)
 * @author KL
 * @date 2019/5/22
 */
@Slf4j
public class BleGatewayMsgDecoder extends MessageToMessageDecoder<DatagramPacket> {
    @Override
    protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {

        ByteBuf data = msg.content();

        BleGatewayMsg bleGatewayMsg = decodeToEntity(data);
        out.add(bleGatewayMsg);
    }


    /**
     *功能描述 将缓冲区中的数据解码为实体对象
     * @author KL
     * @date 2019/5/23
     * @param byteBuf 缓冲区
     * @return com.example.udp_demo.BleGatewayMsg
     */
    public BleGatewayMsg decodeToEntity(ByteBuf byteBuf){
        BleGatewayMsg bleGatewayMsg = BleGatewayMsg.builder().build();
        ReferenceCountUtil.retain(byteBuf);

        /** 消息头 注意:byteBuf.readBytes()方法会将读索引向前移动*/
        bleGatewayMsg.setHeader(NettyUtils.directBufferToHexString(byteBuf.readBytes(2)));
        String version=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String dataType=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        String dataLength=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));

        bleGatewayMsg.setDataType(dataType);
        bleGatewayMsg.setVersion(version);
        bleGatewayMsg.setDataLength(dataLength);
        /**根据数据类型去处理相应的操作*/
        handlerMsg().get(dataType).apply(bleGatewayMsg,byteBuf);

        ReferenceCountUtil.release(byteBuf);
        return bleGatewayMsg;
    }

    public static Map<String, BiFunction> handlerMsg(){
        Map<String,BiFunction> map=new HashMap<>();

        map.put(Constants.GATEWAY_UPLOAD_DISCONNECT_CALLBACK, handlerConnect());
        map.put(Constants.GATEWAY_UPLOAD_CONNECTION_CALLBACK, handlerConnect());
        map.put(Constants.GATEWAY_HEART,handlerHeart());
        map.put(Constants.GATEWAY_SCAN_CALLBACK,handlerScan());
        map.put(Constants.GATEWAY_REPLY_BROADCAST_DATA_QUERY,handlerBroadcast());
        map.put(Constants.GATEWAY_SEND_TRANSPARENT_DATA_CALLBACK,handlerTransparent());
        map.put(Constants.GATEWAY_COMMAND_ERROR,handlerError());

        return map;
    }

    public static BiFunction<BleGatewayMsg,ByteBuf,BleGatewayMsg> handlerConnect(){

        return (bleGatewayMsg, byteBuf) -> handlerConnectOrDisConCallback(bleGatewayMsg,byteBuf);

    }
    public static BiFunction<BleGatewayMsg,ByteBuf,BleGatewayMsg> handlerHeart(){
        return (bleGatewayMsg, byteBuf) -> handlerHeart(bleGatewayMsg,byteBuf);
    }

    public static BiFunction<BleGatewayMsg,ByteBuf,BleGatewayMsg> handlerScan(){
        return (bleGatewayMsg, byteBuf) -> handlerScanCallback(bleGatewayMsg,byteBuf);
    }

    public static BiFunction<BleGatewayMsg,ByteBuf,BleGatewayMsg> handlerBroadcast(){
        return (bleGatewayMsg, byteBuf) -> handlerBroadcastInfo(bleGatewayMsg,byteBuf);
    }

    public static BiFunction<BleGatewayMsg,ByteBuf,BleGatewayMsg> handlerTransparent(){
        return (bleGatewayMsg, byteBuf) -> handlerTransparentCallback(bleGatewayMsg,byteBuf);
    }

    public static BiFunction<BleGatewayMsg,ByteBuf,BleGatewayMsg> handlerError(){
        return (bleGatewayMsg, byteBuf) -> handlerErrorCallback(bleGatewayMsg,byteBuf);
    }

    /**
     *功能描述 处理广播数据
     * @author KL
     * @date 2019/5/22
     * @param bleGatewayMsg
     * @param byteBuf
     * @return BleGatewayMsg
     */
    public static BleGatewayMsg handlerBroadcastInfo(BleGatewayMsg bleGatewayMsg, ByteBuf byteBuf){

        String reserveFiled=NettyUtils.directBufferToHexString(byteBuf.readBytes(4));
        String gatewayMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        Integer equipmentQuantity=NettyUtils.directBufferToINT(byteBuf.readBytes(2));
        log.info("设备数量:{}",equipmentQuantity);
        //根据设备的数量去循环,再根据设备的mac地址来提取每个设备的状态,这个过程可能比较耗时
        //读取时先将read索引清空,返回到初始0位置
        List<ParkingLockInfo> lockInfos=new ArrayList<>();
        int index=0;
        for (int i=0;i<equipmentQuantity;i++){
            //每次都是一个新的设备
            int start=19+69*i;
            ByteBuf sliced = byteBuf.slice(start, 69);
            /** 将设备的信息封装到回调信息中*/
            lockInfos.add(handlerLockInfo(sliced));
            /*byte[] req = new byte[sliced.readableBytes()];
			sliced.readBytes(req);
			log.info("设备{}的数据{}",i,NettyUtils.bytes2HexString(req));*/
            index=start+69;
        }
        bleGatewayMsg.setParkingLockInfos(lockInfos);
        bleGatewayMsg.setGatewayMac(gatewayMac);
        bleGatewayMsg.setReservedField(reserveFiled);
        //将byteBuf的读索引设置到所有设备数据后的第一个位置
        byteBuf.readerIndex(index);
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;

    }
    /**
     *功能描述 处理扫描回调指令
     * @author KL
     * @date 2019/5/22
     * @param bleGatewayMsg
     * @param byteBuf
     * @return BleGatewayMsg
     */
    public static BleGatewayMsg handlerScanCallback(BleGatewayMsg bleGatewayMsg, ByteBuf byteBuf){

        String gatewayMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        String model=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        String interval=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        log.info("网关{}扫描设备策略{},每{}秒一次",gatewayMac,model,interval);
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;
    }

    /**
     *功能描述 处理心跳
     * @author KL
     * @date 2019/5/22
     * @param bleGatewayMsg
     * @param byteBuf
     * @return BleGatewayMsg
     */
    public static BleGatewayMsg handlerHeart(BleGatewayMsg bleGatewayMsg, ByteBuf byteBuf){

        String reserveFiled=NettyUtils.directBufferToHexString(byteBuf.readBytes(4));
        String gatewayMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        bleGatewayMsg.setReservedField(reserveFiled);
        bleGatewayMsg.setGatewayMac(gatewayMac);
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;
    }

    /**
     *功能描述 处理连接结果或断开连接结果
     * @author KL
     * @date 2019/5/22
     * @param bleGatewayMsg
     * @param byteBuf
     * @return BleGatewayMsg
     */
    public static BleGatewayMsg handlerConnectOrDisConCallback(BleGatewayMsg bleGatewayMsg,ByteBuf byteBuf){

        String gatewayMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        String deviceMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        String result=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        log.info("网关{}连接设备{}状态{}",gatewayMac,deviceMac,result);
        bleGatewayMsg.setGatewayMac(gatewayMac);
        bleGatewayMsg.setDeviceMac(deviceMac);
        bleGatewayMsg.setResult(result);
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;
    }

    public static BleGatewayMsg handlerTransparentCallback(BleGatewayMsg bleGatewayMsg,ByteBuf byteBuf){

        String gatewayMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        String deviceMac=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        String result=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        log.info("网关{}透传数据给设备{}状态为{}",gatewayMac,deviceMac,result);
        bleGatewayMsg.setGatewayMac(gatewayMac);
        bleGatewayMsg.setDeviceMac(deviceMac);
        bleGatewayMsg.setResult(result);
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;
    }

    public static BleGatewayMsg handlerErrorCallback(BleGatewayMsg bleGatewayMsg,ByteBuf byteBuf){
        bleGatewayMsg.setGatewayMac(NettyUtils.directBufferToHexString(byteBuf.readBytes(6)));
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;
    }

    public static ParkingLockInfo handlerLockInfo(ByteBuf handler){
        ByteBuf byteBuf=handler.copy(); //为了不影响其他内存操作

        //设备的mac地址
        String macAddr=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
        String RSSI=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        //根据mac地址获取设备信息,判断是否需要更新
        String SIG=NettyUtils.directBufferToHexString(byteBuf.readBytes(9));
        String biz=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String type=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String location=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String number=NettyUtils.directBufferToHexString(byteBuf.readBytes(4));
        String lockStatus=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        String carStatus=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));

        String electricity= NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        String ultrasonicalue=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));

        ReferenceCountUtil.release(byteBuf);
        log.info("设备{}超声波:{}",macAddr,ultrasonicalue);
        ParkingLockInfo parkingLockInfo=new ParkingLockInfo();
        parkingLockInfo.setMacAddr(macAddr);
        parkingLockInfo.setLockStatus(Integer.parseInt(lockStatus,16));
        parkingLockInfo.setCarStatus(Integer.parseInt(carStatus,16));
        parkingLockInfo.setBatteryLevel(Integer.parseInt(electricity,16));
        //log.info("锁信息:{}",parkingLockInfo);

        return  parkingLockInfo;
    }

}
