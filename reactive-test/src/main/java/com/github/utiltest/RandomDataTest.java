package com.github.utiltest;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.nio.charset.Charset;

public class RandomDataTest {

    public static void main(String[] args) {

        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(Charset.forName("UTF-8"))
                //.timeRange(9, 5)
                //.dateRange(today, tomorrow)
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        EasyRandom easyRandom = new EasyRandom();
        User person = easyRandom.nextObject(User.class);
        System.out.println(person.toString());
    }
}
