package com.github.rpccore.annotation;


import com.github.rpccore.registry.ServiceRegistry;
import com.github.rpccore.sever.RPCServerHandler;
import com.github.rpccore.sever.RandomPortServiceStarter;
import com.github.rpccore.sever.ServerChannelInitializer;
import com.github.rpccore.sever.ServiceProvider;
import org.springframework.context.annotation.Bean;


public class ServiceRegistryAutoConfiguration {
	@Bean
	public ServiceRegistry serviceRegistry() {
		return new ServiceRegistry();
	}
	@Bean
	public ServiceProvider serviceProvider() {
		return new ServiceProvider();
	}
	@Bean
	public RPCServerHandler rpcServerHandler() {
		return new RPCServerHandler();
	}
	@Bean
	public ServerChannelInitializer serverChannelInitializer() {
		return new ServerChannelInitializer();
	}

	@Bean
	public RandomPortServiceStarter serviceStarter() {
		return new RandomPortServiceStarter();
	}
}
