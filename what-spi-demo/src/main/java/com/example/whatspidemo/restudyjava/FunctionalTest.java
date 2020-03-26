package com.example.whatspidemo.restudyjava;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalTest {

    static void testCompare(int src, double limit) {
        double d=src*10.0;
        if (d<limit){
            System.out.println("Success: " + d);
        }else {
            System.out.println("Failure: " + d);
        }
    }

    /**
     *  使用函数式编程模拟实现一个比较大小（x*10与limit），并返回结果提示功能，感觉函数式编程更适合科学计算
     * @param src
     * @param limit
     */
    static void testSourceAndCondition(int src, double limit) {

        // 取值
        Supplier<Integer> source = () -> {
            Integer res = src;
            return res;
        };
        //
        Function<Integer, Double> process = i -> i * 10.0;
        Predicate<Double> condition = num -> {
            System.out.println("Test if	" + num + "	is smaller than " + limit);
            return num < limit;
        };
        Consumer<Double> success = d -> System.out.println("Success: " + d);
        Consumer<Double> failure = d -> System.out.println("Failure: " + d);
        calculate(source, process, condition, success, failure);
    }

    /**
     *  这里展示了函数当作参数传递
     * @param source
     * @param process
     * @param condition
     * @param success
     * @param failure
     */
    static void calculate(Supplier<Integer> source, Function<Integer, Double> process, Predicate<Double> condition, Consumer<Double> success, Consumer<Double> failure) {
        int i = source.get();
        double res = process.apply(i);
        if (condition.test(res)) {
            success.accept(res);
        } else {
            failure.accept(res);
        }
    }

    public static void main(String[] args) {

        testCompare(2,10);
        System.out.println("------------------");
        testSourceAndCondition(2,10);
    }
}
