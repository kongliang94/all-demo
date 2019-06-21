package com.github.rpccore.client;



import com.github.rpccore.codec.RPCDecoder;
import com.github.rpccore.codec.RPCEncoder;
import com.github.rpccore.pojo.RPCResponse;
import com.github.rpccore.pojo.RpcCall;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Created by haoyifen on 2017/6/17 17:28.
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
	public RPCClientHandlerImpl getRpcClientHandler() {
		return rpcClientHandler;
	}

	private RPCClientHandlerImpl rpcClientHandler = new RPCClientHandlerImpl();

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4, 0, 4)).addLast(new RPCDecoder<RPCResponse>() {})
				.addLast(new LengthFieldPrepender(4, false)).addLast(new RPCEncoder<RpcCall>() {}).addLast(rpcClientHandler);
	}
}
