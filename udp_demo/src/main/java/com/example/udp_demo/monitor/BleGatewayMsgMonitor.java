package com.example.udp_demo.monitor;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class BleGatewayMsgMonitor {

    private final EventLoopGroup group;

    private final Bootstrap bootstrap;
    public BleGatewayMsgMonitor(InetSocketAddress address) {
        group = new NioEventLoopGroup();

        bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler( new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel)
                            throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new BleGatewayMsgDecoder());
                        pipeline.addLast(new BleGatewayMsgHandler());
                    }
                } )
                .localAddress(address);
    }
    public Channel bind() {
        return bootstrap.bind().syncUninterruptibly().channel();
    }
    public void stop() {
        group.shutdownGracefully();
    }
    public static void main(String[] args) throws Exception {

        BleGatewayMsgMonitor monitor = new BleGatewayMsgMonitor(
                new InetSocketAddress(Integer.parseInt(args[0])));
        try {
            Channel channel = monitor.bind();
            System.out.println("BleGatewayMsgMonitor running");
            channel.closeFuture().sync();
        } finally {
            monitor.stop();
        }
    }
}
