package com.example.demo.BaseTest;

/**
 * @description: 3
 * @author: KL
 * @create: 2019-09-03
 */
public class InterfaceTest {


    public static void main(String[] args) {
        Thing thing=new Pen();
        thing.getName();
        thing.test();
        System.out.println(Thing.a);
        System.out.println(Pen.a);
        System.out.println(Thing.b);
    }
}

abstract class MyThing{
    private void getAge(){
        System.out.println("我是thing,没人可以改变,age=1");
    }

    protected void getTwo(){

    }

    public abstract void getName();

    //public abstract static void kk();//abstract不能修饰static方法

    public MyThing(){

    }
    public static String getAddr(){
        System.out.println("我是thing接口,static方法");
        return "";
    }
    public void my(){

    }

    // default void your() { } //default只能在接口

    private static int a = 1;
    public static final int b = 2;
}

interface Thing{
    /*private void getAge(){  // 1.8报错 11不报错
        System.out.println("我是thing,没人可以改变,age=1");
    }*/
    //public void getOne(){ } // 报错 接口抽象方法不应该有方法体

    //protected void getTwo(){ }// 报错 protected不应该出现interface这里

    public void getName();

    //private void getThree();// 报错 private方法在接口中应该有方法体

    //public static void getAddr(); // 报错 static方法在接口中应该有方法体

    public static String getAddr(){
        System.out.println("我是thing接口,static方法");
        return "";
    }

   // default void test(); //报错，必须有方法体

    default void test(){
        System.out.println("接口的test");
    }

    void test2();

    static int a = 1;
    static final int b = 2;
    // private static int a1 = 1; //报错 private 不应该出现在这里
    public static final int b1 = 2;
}

class Pen implements Thing{

    static int a = 5; //覆盖父类的a

    private static String staticString=getAddr();
    @Override
    public void getName() {
        System.out.println("Pen");
    }

    private void getAge(){
        System.out.println("我是pen");
    }

    public static String getAddr(){
        System.out.println("我是pen,static方法");
        return "";
    }

    @Override
    public void test() {
        System.out.println("实现类的test");
    }

    @Override
    public void test2() {

    }
}

