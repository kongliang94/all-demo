package com.example.demo.ThreadStudy;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<Object> resultFuture
                = executorService.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        }, 1, TimeUnit.SECONDS);

        //ScheduledFuture<Object> resultFuture = executorService.scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);
    }
}
