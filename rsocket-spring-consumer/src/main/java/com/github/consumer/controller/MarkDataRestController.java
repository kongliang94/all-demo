package com.github.consumer.controller;

import com.github.consumer.entity.MarketData;
import com.github.consumer.entity.MarketDataRequest;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MarkDataRestController {
    private final RSocketRequester requester;

    public MarkDataRestController(RSocketRequester requester) {
        this.requester = requester;
    }

    /**
     *功能描述 Request/Response模式,目前通用的请求/响应模式
     * @author KL
     * @date 2019/5/27
     * @param stock
     * @return org.reactivestreams.Publisher<com.github.consumer.entity.MarketData>
     */
    @GetMapping("/current/{stock}")
    public Publisher<MarketData> current(@PathVariable String stock){
        return requester
                .route("currentMarketData")
                .data(new MarketDataRequest(stock))
                .retrieveMono(MarketData.class);
    }
    /**
     *功能描述 Request/Stream模式  ,一个简单的请求返回多个响应.
     * Request/Stream模式是一个更复杂的交互模型，其中客户机发送一个请求，但是在一段时间内从服务器获得多个响应。
     * @author KL
     * @date 2019/5/27
     * @param stock
     * @return org.reactivestreams.Publisher<com.github.consumer.entity.MarketData>
     */
    @GetMapping(value = "/feed/{stock}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<MarketData> feed(@PathVariable("stock") String stock) {
        return requester.route("feedMarketData")
                .data(new MarketDataRequest(stock))
                .retrieveFlux(MarketData.class);
    }

    /**
     *功能描述 Fire And Forget模式,其实就是Client推送给Server端
     * @author KL
     * @date 2019/5/27
     * @param
     * @return org.reactivestreams.Publisher<java.lang.Void>
     */
    @GetMapping(value = "/collect")
    public Publisher<Void> collect() {
        return requester.route("collectMarketData")
                .data(getMarketData())
                .send();
    }

    private MarketData getMarketData() {
        return new MarketData("X", new Random().nextInt(10));
    }
}
