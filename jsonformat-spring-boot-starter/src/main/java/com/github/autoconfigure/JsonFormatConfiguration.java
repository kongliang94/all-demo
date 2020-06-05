package com.github.autoconfigure;

import com.github.format.FormatProperties;
import com.github.FormatTemplate;
import com.github.format.FastjsonFormatProcessor;
import com.github.format.FormatProcessor;
import com.github.format.GsonFormatProcessor;
import com.github.format.JacksonFormatProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(FormatProperties.class)
@Configuration
public class JsonFormatConfiguration {

    @Bean
    public FormatTemplate formatTemplate(FormatProperties formatProperties,FormatProcessor formatProcessor){

        if ("fastjson".equals(formatProperties.getType())){
            return new FormatTemplate(new FastjsonFormatProcessor());
        }else if ("gson".equalsIgnoreCase(formatProperties.getType())){
            return new FormatTemplate(new GsonFormatProcessor());
        }else if ("jackson".equalsIgnoreCase(formatProperties.getType())){
            return new FormatTemplate(new JacksonFormatProcessor());
        }
        return new FormatTemplate(formatProcessor);
    }
}
