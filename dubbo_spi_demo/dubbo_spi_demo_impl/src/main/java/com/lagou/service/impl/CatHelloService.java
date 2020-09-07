package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.dubbo.common.URL;

public class CatHelloService implements HelloService {
    public String sayHello() {
        return "miaomiao";
    }

    public String sayHello(URL url) {
        return "miaomiao"+url.getAbsolutePath();
    }
}
