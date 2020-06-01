package com.github.autoconfigure;


import com.github.format.FastjsonFormatProcessor;
import com.github.format.FormatProcessor;
import com.github.format.GsonFormatProcessor;
import com.github.format.JacksonFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FormatAutoConfiguration {

    @Primary //默认开启fastjson
    @Bean
    @ConditionalOnClass(name="com.alibaba.fastjson.JSON")
    public FormatProcessor fastjsonFormatProcessor(){
        return new FastjsonFormatProcessor();
    }

    @Bean
    @ConditionalOnClass(name="com.google.gson.Gson")
    public FormatProcessor gsonFormatProcessor(){
        return new GsonFormatProcessor();
    }

    @Bean
    @ConditionalOnClass(name="com.fasterxml.jackson.core.ObjectMapper")
    public FormatProcessor jacksonFormatProcessor(){
        return new JacksonFormatProcessor();
    }
}
