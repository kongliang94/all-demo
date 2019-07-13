package com.github.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        ByteBuf byteBuf = msg.copy();
        log.info("channelRead-info-");
        String header=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String version=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        String dataType=NettyUtils.directBufferToHexString(byteBuf.readBytes(1));
        String dataLength=NettyUtils.directBufferToHexString(byteBuf.readBytes(2));
        log.info("channelRead-info-dataLengt{}",dataLength);
    }
}
