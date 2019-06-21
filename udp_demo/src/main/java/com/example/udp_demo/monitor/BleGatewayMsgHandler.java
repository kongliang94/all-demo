package com.example.udp_demo.monitor;

import com.example.udp_demo.BleGatewayMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BleGatewayMsgHandler extends SimpleChannelInboundHandler<BleGatewayMsg> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BleGatewayMsg msg) throws Exception {
        log.info("解码后的实体类"+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
