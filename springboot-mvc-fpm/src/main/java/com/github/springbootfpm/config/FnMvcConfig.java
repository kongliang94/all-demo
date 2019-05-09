package com.github.springbootfpm.config;

import com.github.springbootfpm.handler.PostHandler;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.MultipartConfigElement;

import static org.springframework.web.servlet.function.RequestPredicates.*;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class FnMvcConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(PostHandler postHandler) {
        return route(GET("/posts"), postHandler::all)
                .andRoute(POST("/posts"), postHandler::create)
                .andRoute(GET("/posts/{id}"), postHandler::get)
                .andRoute(PUT("/posts/{id}"), postHandler::update)
                .andRoute(DELETE("/posts/{id}"), postHandler::delete);
    }
}
