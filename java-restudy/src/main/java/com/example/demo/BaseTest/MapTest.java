package com.example.demo.BaseTest;

import com.example.demo.mockspringioc.controller.UserController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        final Class<? extends Map> clazz = HashMap.class;
        try {
            Object o=clazz.getDeclaredConstructor().newInstance();
            Stream.of(clazz.getMethods()).forEach(method -> {
                System.out.println(method.getName());
                if (method.getName().equals("put")){
                    try {
                        method.invoke(o,new Object[]{"kk","vv"});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });

            Method m = clazz.getMethod("get", Object.class);
            System.out.println(m.invoke(o,"kk"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
