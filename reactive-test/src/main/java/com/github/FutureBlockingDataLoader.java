package com.github;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureBlockingDataLoader extends DataLoader {
    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池

        Future<?> future1= executorService.submit(super::loadConfigurations);
        Future<?> future2= executorService.submit(super::loadUsers);
        Future<?> future3= executorService.submit(super::loadOrders);

//        runCompletely(executorService.submit(super::loadConfigurations));  //  耗时 >= 1s
//        runCompletely(executorService.submit(super::loadUsers));           //  耗时 >= 2s
//        runCompletely(executorService.submit(super::loadOrders));          //  耗时 >= 3s
        executorService.shutdown();
    } // 总耗时 sum(>= 1s, >= 2s, >= 3s)  >= 6s

    private void runCompletely(Future<?> future) {
        try {
            future.get(); // 阻塞等待结果执行
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }
}

