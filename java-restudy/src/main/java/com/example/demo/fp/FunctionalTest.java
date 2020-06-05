package com.example.demo.fp;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式编程demo
 */
public class FunctionalTest {

    static void testCompare1(int src, double limit) {
        double d= src*src+src * 10.0;
        if (d < limit){
            System.out.println("Success: " + d);
        }else {
            System.out.println("Failure: " + d);
        }
    }

    /**
     *  使用函数式编程模拟实现一个比较大小（x*x+10*x与limit），并返回结果提示功能
     * @param src x
     * @param limit 结果
     */
    static void testCompare2(int src, double limit) {

        // 取值
        Supplier<Integer> source = () -> {
            return src;
        };
        //构造一个函数
        Function<Integer, Double> process = i -> i*i+i * 10.0;

        // 条件
        Predicate<Double> condition = num -> {
            //System.out.println("Test if	" + num + "	is smaller than " + limit);
            return num < limit;
        };
        // 结果
        Consumer<Double> success = d -> System.out.println("Success: " + d);
        Consumer<Double> failure = d -> System.out.println("Failure: " + d);

        // 展示函数当作参数传递
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

        System.out.println("====正常方法=====");
        testCompare1(2,10);
        System.out.println("====函数式方法=====");
        testCompare2(2,10);
    }
}
