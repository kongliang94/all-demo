package com.github.sentineldemo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class FlowService {
    @SentinelResource(value = "com.github.sentineldemo.service.FlowService:test",blockHandler = "testBlockHandler")
    public String test(){
        System.out.println("正常执行");
        return "test";
    }


    public String testBlockHandler(BlockException blockException){
        System.out.println("流控执行,"+blockException);
        return "流控执行";
    }
}
