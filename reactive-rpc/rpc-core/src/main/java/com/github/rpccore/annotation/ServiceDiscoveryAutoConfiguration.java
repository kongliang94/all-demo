package com.github.rpccore.annotation;


import com.github.rpccore.client.ConnectionManager;
import com.github.rpccore.client.ServiceProxyUtil;
import com.github.rpccore.registry.ServiceDiscovery;
import org.springframework.context.annotation.Bean;


public class ServiceDiscoveryAutoConfiguration {
	@Bean
	public ServiceDiscovery serviceDiscovery() {
		return new ServiceDiscovery();
	}
	@Bean
	public ConnectionManager connectionManager() {
		return new ConnectionManager();
	}
	@Bean
	public ServiceProxyUtil serviceProxyUtil(){
		return new ServiceProxyUtil();
	}
}
