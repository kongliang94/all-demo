package com.github;


import com.github.config.RedisDistributedLocker;
import com.github.dao.BalanceDao;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class LockerTest {
    @Resource
    private BalanceDao balanceDao;
    @Resource
    private RedisDistributedLocker locker;
    
    @Async
    @Scheduled(fixedRate = 2)
    public void test() throws Exception { // 多线程访问
        if (balanceDao.getBalance() <= 0) {
            return;
        }
//        testSpend();
//        testSpendWithCallBack();
        testSpendWithMutexAnnotation();
    }

    public void testSpend() throws Exception {
        balanceDao.spend(2);
    }

    public void testSpendWithCallBack() throws Exception {
        final String key = String.format("lock:balance:%s", 1);
        locker.executeIfLocked(key, 5, () -> {
            balanceDao.spend(4);
        });
    }
    
    public void testSpendWithMutexAnnotation() throws Exception {
        balanceDao.mutexSpend(1, 2);
//        balanceDao.wrongTestMutexSpend(1, 2);
//        balanceDao.rightTestMutexSpend(1, 2);
    }
}
