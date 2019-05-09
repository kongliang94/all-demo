package com.example.udp_demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: KL
 * @Date: 2019/5/8 17:41
 * @Description: 注意Netty对于UDP没有提供在Channel中自动编解码,所以需要自定义解码器
 */

@Slf4j
public class BleGatewayProtocolDecoder {

    public static BleGatewayMsg decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        BleGatewayMsg bleGatewayMsg = BleGatewayMsg.builder().build();

        // 缓存数据长度(以字节位单位计算)
        int length = byteBuf.readableBytes();
        log.info("缓存数据长度length: " + length);

        /** 消息头 */
        bleGatewayMsg.setHeader(NettyUtils.directBufferToHexString(byteBuf.readBytes(2)));
        String version=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String dataType=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        String dataLength=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));

        bleGatewayMsg.setDataType(dataType);
        bleGatewayMsg.setVersion(version);
        bleGatewayMsg.setDataLength(dataLength);
        String macAddr="";
        String reserveFiled="";
        switch (dataType)
        {
            case Constants.GATEWAY_SCAN_CALLBACK:
                break;
                default:
                    //默认心跳
                    reserveFiled=NettyUtils.directBufferToHexString(byteBuf.readBytes(4));
                    macAddr=NettyUtils.directBufferToHexString(byteBuf.readBytes(6));
                    bleGatewayMsg.setReservedField(reserveFiled);
                    break;

        }
        bleGatewayMsg.setDeviceMac(macAddr);
        bleGatewayMsg.setCheckValue(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        bleGatewayMsg.setTail(NettyUtils.directBufferToHexString(byteBuf.readBytes(1)));
        return bleGatewayMsg;
    }
}
