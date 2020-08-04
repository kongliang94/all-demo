package com.example.demo.mockspringioc;

import com.example.demo.mockspringioc.controller.UserController;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class MyTest1 {

    public static void main(String[] args) {
        UserController userController=new UserController();

        final Class<? extends UserController> clazz = userController.getClass();

        Stream.of(clazz.getDeclaredFields()).forEach(
                field -> {
                    String name=field.getName();
                    //System.out.println(name);
                    // 注解方式
                    AutoWired annotation=field.getAnnotation(AutoWired.class);
                    if (annotation!=null){
                        field.setAccessible(true);

                        // 变量类型
                        Class<?> type = field.getType();
                        Object instance = null;
                        try {
                            //instance = type.newInstance();  jdk9开始废弃
                            //Class<?>[] empty = {};
                            //instance=type.getDeclaredConstructor(empty).newInstance((Object[])null);
                            instance=type.getDeclaredConstructor().newInstance();
                            field.set(userController,instance);
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
        );

        System.out.println(userController.getUserService());
    }
}
