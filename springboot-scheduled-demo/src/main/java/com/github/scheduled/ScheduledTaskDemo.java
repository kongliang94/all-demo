package com.github.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 定时任务测试demo
 * @author: KL
 * @create: 2020-05-16
 */
@Component
@Slf4j
public class ScheduledTaskDemo {
    @Scheduled(cron = "0/10 * * * * *")
    public void execute() {
        log.info("First scheduled task is starting... ...");
        log.info("First scheduled task is ending... ...");
    }
}
