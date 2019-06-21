package com.example.udp_demo.monitor;

import com.example.udp_demo.BleGatewayProtocolEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BleGatewayer implements Runnable{


    static final int PORT = Integer.parseInt(System.getProperty("port", "9998"));



    @Override
    public void run() {
        EventLoopGroup group = new NioEventLoopGroup();
        //自定义handler
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
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChannelInitializer<Channel>() {
                        /**
                         *ChannelInitializer的用法，也就是要自己定义initChannel函数，当当前的channel被注册到eventloop上面之后，
                         * 会用该用户定义的函数来初始化channel，一般都是一些加入handler的操作
                         */
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new BleGatewayMsgDecoder());
                            pipeline.addLast(new BleGatewayMsgHandler());
                        }
                    });
                            // 开启server
            ChannelFuture f = b.bind(PORT).sync();

            log.info("udp-monitor running {}",PORT);
            // 等待阻塞直到server被关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            //关闭所有事件循环以终止所有线程
            group.shutdownGracefully();
        }
    }
}
