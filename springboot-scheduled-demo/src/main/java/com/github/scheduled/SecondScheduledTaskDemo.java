package com.github.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 第二个定时任务测试demo
 * @author: KL
 * @create: 2020-05-16
 */
@Component
@Slf4j
public class SecondScheduledTaskDemo {

    @Scheduled(cron = "0/10 * * * * *")
    public void execute() {
        log.info("Second scheduled task is starting... ...");
        log.info("Second scheduled task is ending... ...");
    }
}
