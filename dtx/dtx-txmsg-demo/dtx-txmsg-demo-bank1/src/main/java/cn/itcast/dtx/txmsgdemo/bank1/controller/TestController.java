package cn.itcast.dtx.txmsgdemo.bank1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试下go的负载均衡
 * @author: KL
 * @create: 2020-04-01
 */
@RestController
public class TestController {
    @GetMapping("")
    public  String  getIndex() {
        return "我是3031";
    }
}
