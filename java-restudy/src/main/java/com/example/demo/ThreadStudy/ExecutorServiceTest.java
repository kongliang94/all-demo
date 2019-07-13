package com.example.demo.ThreadStudy;

import com.example.demo.ThreadStudy.CompletableFutureExample.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3
        ); // 创建线程池
        CompletionService completionService = new ExecutorCompletionService(executorService);
        long start = System.currentTimeMillis();

        List<Car> cars = cars();
        cars.forEach(car -> {
            completionService.submit(()->{
                float rating = rating(car.getManufacturerId());
                car.setRating(rating);}, null);
        });
            //  耗时 >= 1s
                   //  耗时 >= 3s
        int count = 0;
        while (count < 3) { // 等待三个任务完成
            if (completionService.poll() != null) {
                count++;
            }
        }
        executorService.shutdown();
        cars.forEach(System.out::println);

        long end = System.currentTimeMillis();

        System.out.println("Took " + (end - start) + " ms.");

    }

    static float rating(int manufacturer) {
        try {
            simulateDelay();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        switch (manufacturer) {
            case 2:
                return 4f;
            case 3:
                return 4.1f;
            case 7:
                return 4.2f;
            default:
                return 5f;
        }
    }

    static List<Car> cars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, 3, "Fiesta", 2017));
        carList.add(new Car(2, 7, "Camry", 2014));
        carList.add(new Car(3, 2, "M2", 2008));
        return carList;
    }

    private static void simulateDelay() throws InterruptedException {
        Thread.sleep(5000);
    }
}
