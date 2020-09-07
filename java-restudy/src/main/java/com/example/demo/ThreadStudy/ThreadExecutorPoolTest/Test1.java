package com.example.demo.ThreadStudy.ThreadExecutorPoolTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class Test1 {

    //corePoolSize 核心线程数
    //maximumPoolSize 最大线程数
    //keepAliveTime 线程空闲时间
    //TimeUnit 线程空闲时间 单位
    //BlockingQueue  线程等待队列
    //ThreadFactory  创建线程工厂
    //RejectedExecutionHandler  线程拒绝处理器
    //    ThreadPoolExecutor.AbortPolicy  直接拒接
    //    ThreadPoolExecutor.CallerRunsPolicy   让调用线程池的线程执行  在此就是main执行
    //    ThreadPoolExecutor.DiscardOldestPolicy   丢弃最旧的等待队列中的线程  在此就是任务4
    //    ThreadPoolExecutor.DiscardPolicy   和AbortPolicy一样,只不过不抛异常,静默丢弃
    // 线程池
    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(16, 24, 2000, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(90),new CustomThreadFactory("测试类别线程"));
    public static void main(String[] args) {
        // 参数
        for (int i = 0; i < 108; i++) {
            int finalI = i;
            executor.execute(()->{
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+" "+finalI);
                    // 可以看到当队列里排满任务后，将开启最大线程数
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
