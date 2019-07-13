package com.example.demo.ThreadStudy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ScheduledExecutorServiceDemo {
    private void execute() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private void executeWithMultiThread() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private Function<ScheduledExecutorService, Void> getTasksToRun() {
        return (executorService -> {
            ScheduledFuture<?> scheduledFuture1 = executorService.schedule(() -> {
                // Task
                System.out.println(1);
            }, 1, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(() -> {
                // Task
                System.out.println(2);
            }, 2, 10, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture3 = executorService.scheduleWithFixedDelay(() -> {
                // Task
                System.out.println(3);
            }, 3, 10, TimeUnit.SECONDS);

            ScheduledFuture<String> scheduledFuture4 = executorService.schedule(() -> {
                // Task
                return "Hellow world";
            }, 1, TimeUnit.MINUTES);
            return null;
        });
    }

    public static void main(String... args) {
        ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
        demo.execute();
        demo.executeWithMultiThread();
    }
}
