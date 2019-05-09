package com.example.udp_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: KL
 * @Date: 2019/5/7 20:43
 * @Description:
 */
@Slf4j
public class UdpServer implements Runnable{

    static final int PORT = Integer.parseInt(System.getProperty("port", "9998"));

    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        //自定义handler
        final EchoUdpServerHandler serverHandler = new EchoUdpServerHandler();
        try {
            //udpserver端引导启动类
            /**
             * 服务器致力于使用一个父 Channel 来接受
             * 来自客户端的连接， 并创建子 Channel 以用于它们之间的通信；而客户端将最可能只需要一个
             * 单独的、 没有父 Channel 的 Channel 来用于所有的网络交互。（正如同我们将要看到的，这也
             * 适用于无连接的传输协议，如 UDP，因为它们并不是每个连接都需要一个单独的 Channel。
             */
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .handler(new EchoUdpServerHandler());
            // 开启server
            ChannelFuture f = b.bind(PORT).sync();
            log.info("开启server prot: {}",PORT);
            // 等待阻塞直到server被关闭
            f.channel().closeFuture().sync();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            //关闭所有事件循环以终止所有线程
            group.shutdownGracefully();
        }
    }

    /**
     * 主动下发数据
     */
    public void proactivelyDeliveringData(){

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioDatagramChannel.class)
                .handler(new EchoUdpServerHandler());

    }
}
