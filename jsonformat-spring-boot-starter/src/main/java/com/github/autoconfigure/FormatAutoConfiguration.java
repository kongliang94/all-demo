package com.github.autoconfigure;


import com.github.condition.JacksonCondition;
import com.github.format.FastjsonFormatProcessor;
import com.github.format.FormatProcessor;
import com.github.format.GsonFormatProcessor;
import com.github.format.JacksonFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 本配置类其实与spring-boot-starter的实现没啥关系，主要是为了解释Conditionals
 * 深入了解：https://www.marcobehler.com/guides/spring-boot#_spring_boot_basics_conditionals
 */
@Configuration
public class FormatAutoConfiguration {

    /**
     * 下边3个Conditional注解代表三种满足条件下 bean注入
     *  关于springboot，Conditional是springboot中每个组件的基础，判断是否使用该组件
     */
    @Bean
    @ConditionalOnProperty(prefix = "json.format", name = "enabled", havingValue = "true") //使用属性判断是否注入bean
    public FormatProcessor fastjsonFormatProcessor(){
        return new FastjsonFormatProcessor();
    }

    @Primary //默认开启jackson
    @Bean
    @ConditionalOnClass(name="com.google.gson.Gson") //在classpath下存在com.google.gson.Gson则注入bean
    public FormatProcessor gsonFormatProcessor(){
        return new GsonFormatProcessor();
    }

    @Bean
    @Conditional(JacksonCondition.class)  //使用condition判断是否注入bean
    public FormatProcessor jacksonFormatProcessor(){
        return new JacksonFormatProcessor();
    }
}
