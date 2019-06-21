package com.github.rpccore.client;


import co.paralleluniverse.strands.SettableFuture;
import com.github.rpccore.pojo.RPCResponse;
import com.github.rpccore.pojo.RpcCall;

/**
 * Created by haoyifen on 2017/6/19 14:58.
 */
public interface RPCClientHandler {
	SettableFuture<RPCResponse> sendRequest(RpcCall rpcCall);
}