package com.example.udp_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Auther: KL
 * @Date: 2019/5/9 11:53
 * @Description:
 */
public class BleGatewayProtocolEncoder extends MessageToMessageEncoder<BleGatewayMsg>{

    private final InetSocketAddress remoteAddress; //远程访问地址
    private final String command;                  //下发指令

    public BleGatewayProtocolEncoder(InetSocketAddress address, String command) {
        this.remoteAddress = address;
        this.command=command;
    }

    /**
     * 将指令编码为byte数组发送给蓝牙网关
     */
    public void encode(){

    }

    @Override
    protected void encode(ChannelHandlerContext ctx, BleGatewayMsg msg, List<Object> out) throws Exception {
        ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        buff.writeBytes(NettyUtils.hexString2Bytes(command));
        //out.add(new DatagramPacket(buff,remoteAddress));
    }
}
