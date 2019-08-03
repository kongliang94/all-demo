package com.superstation.config;

import com.superstation.handler.Air1m20191001BHandler;
import com.superstation.handler.Moniter5m20191001BHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class FnMvcConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(Moniter5m20191001BHandler moniter5m20191001BHandler) {
        return route(GET("/moniter5m20191001B"), moniter5m20191001BHandler::all)
                .andRoute(POST("/moniter5m20191001B"), moniter5m20191001BHandler::create)
                .andRoute(GET("/moniter5m20191001B/{id}"), moniter5m20191001BHandler::get)
                //.andRoute(PUT("/Moniter5m20191001B/{id}"), postHandler::update)
                .andRoute(DELETE("/moniter5m20191001B/{id}"), moniter5m20191001BHandler::delete);
    }

    @Bean
    public RouterFunction<ServerResponse> air1m20191001BRoutes(Air1m20191001BHandler air1m20191001BHandler) {
        return route(GET("/air1m20191001B"), air1m20191001BHandler::all)
                .andRoute(GET("/air1m20191001B/{detectionItmeCode}/all"),air1m20191001BHandler::allByDate)
                .andRoute(GET("/air1m20191001B/{id}"), air1m20191001BHandler::get);
    }

}
