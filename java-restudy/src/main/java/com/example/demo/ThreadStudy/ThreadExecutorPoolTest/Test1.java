package com.example.demo.ThreadStudy.ThreadExecutorPoolTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {


    // 线程池
    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 24, 2000, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(100),new CustomThreadFactory("测试类别线程"));
    public static void main(String[] args) {
        // 参数
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executor.execute(()->{
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+" "+finalI);
                    System.out.println("executor.getActiveCount():"+executor.getActiveCount());
                    System.out.println("executor.getQueue().size():"+executor.getQueue().size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }

    static class CustomThreadFactory implements ThreadFactory {
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        CustomThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix+"-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread( r,namePrefix + threadNumber.getAndIncrement());
            if (t.isDaemon()) {
                t.setDaemon(true);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

}
