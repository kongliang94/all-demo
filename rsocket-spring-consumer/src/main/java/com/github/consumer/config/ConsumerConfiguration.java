package com.github.consumer.config;

import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;

@Lazy
@Configuration
public class ConsumerConfiguration {

    @Bean
    RSocket rSocket() {
        return RSocketFactory
                .connect()
                .dataMimeType(MimeTypeUtils.APPLICATION_JSON_VALUE)
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .transport(TcpClientTransport.create("47.96.70.206",7000))
                .start()
                .block();
    }

    @Bean
    RSocketRequester requester(RSocketStrategies rSocketStrategies) {
        return RSocketRequester.create(this.rSocket(),
                MimeTypeUtils.APPLICATION_JSON, rSocketStrategies);
    }
}


