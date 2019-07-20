package com.example.demo.ThreadStudy;

import java.util.concurrent.*;

/**
 *  我称之为计划表线程池
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        /*Runnable beeper = () -> System.out.println("beep");
        ScheduledFuture<?> beeperHandle
                = scheduler.scheduleWithFixedDelay(beeper,0,3, TimeUnit.SECONDS);

        Runnable canceller = () -> beeperHandle.cancel(true);
        scheduler.schedule(canceller,10,TimeUnit.SECONDS);*/
        //scheduler.shutdown();

        for (int i=0;i<7;i++){
            Runnable beeper = () -> System.out.println("beep");
            ScheduledFuture<?> beeperHandle
                    = scheduler.schedule(beeper,3*i, TimeUnit.SECONDS);

            //Runnable canceller = () -> beeperHandle.cancel(true);
            //scheduler.schedule(canceller,i*3,TimeUnit.SECONDS);

        }
        try {
            Thread.sleep(21000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown();
    }
}
