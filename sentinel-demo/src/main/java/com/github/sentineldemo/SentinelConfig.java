package com.github.sentineldemo;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Configuration
public class SentinelConfig {

    private static final String KEY = "com.github.sentineldemo.service.FlowService:test";

    private static final Integer count = 25;

    @PostConstruct
    public  void initFlowRules(){
        List<FlowRule> rules = new ArrayList<FlowRule>();
        FlowRule rule = new FlowRule();
        rule.setResource(KEY);
        rule.setCount(count);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
        rule.setMaxQueueingTimeMs(20 * 1000);

        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
