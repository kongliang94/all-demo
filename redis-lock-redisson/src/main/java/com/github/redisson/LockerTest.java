package com.github.redisson;



import com.github.redisson.annotation.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Slf4j
@Component
public class LockerTest {


    @Autowired
    RedissonLock redissonLock;

    /**
     * 模拟这个是商品库存
     */
    public static volatile Integer TOTAL = 1000;

    @DistributedLock(value="goods", expireSeconds=1)
    public String lockDecreaseStock() throws InterruptedException {
        if (TOTAL > 0) {
            TOTAL--;
        }
        log.info("===注解模式=== 减完库存后,当前库存1===" + TOTAL);
        Thread.sleep(2000);
        //log.info("===注解模式=== 减完库存后,当前库存2===" + TOTAL);
        return "=================================";
    }
    @Async
    @Scheduled(fixedRate = 100)
    public void test() throws Exception { // 多线程访问

        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    lockDecreaseStock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
