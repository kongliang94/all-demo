package com.example.udp_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: KL
 * @Date: 2019/5/8 12:07
 * @Description:
 */
@Slf4j
@ChannelHandler.Sharable //注解用来说明ChannelHandler是否可以在多个channel直接共享使用。
public class EchoUdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {

        ByteBuf buf = (ByteBuf) datagramPacket.copy().content();
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        //注意保存ip:port
        String ip=datagramPacket.sender().getHostString();
        Integer port=datagramPacket.sender().getPort();

        log.info("ip:port={}:{}",ip,port);

        BleGatewayMsg bleGatewayMsg=BleGatewayProtocolDecoder.decode(channelHandlerContext,datagramPacket.content());

        System.out.println("【NOTE】>>>>>> 收到客户端的数据："+bleGatewayMsg.toString());
        String body = NettyUtils.bytes2HexString(req);
        System.out.println("【NOTE】>>>>>> 收到客户端的数据："+body);

        //ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        //buff.writeBytes(hexString2Bytes(body));
        // 回复一条信息给客户端
        //channelHandlerContext.writeAndFlush(new DatagramPacket(buff, datagramPacket.sender())).sync();
    }
}
