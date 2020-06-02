package com.example.demo.ThreadStudy.countdownlacth;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {
    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50,
            0L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {


            long start=System.currentTimeMillis();
            List<String> strings=lastestFeedsByFuture("11");
            long end=System.currentTimeMillis();
            System.out.println(end-start);
            System.out.println(strings);
        }
        executor.shutdown();
        //System.out.println(strings);
    }
    public static List<String> lastestFeeds(String wxId) {


        final List<String> list=new ArrayList<>();

        final CountDownLatch latch = new CountDownLatch(7);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //1. 获取你得好友列表
                    Thread.sleep(100);
                    list.add("kl");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //2. 去掉把你删除的好友
                    Thread.sleep(100);
                    list.add("kl1");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //3. 去掉被你删除的好友
                    Thread.sleep(100);
                    list.add("kl2");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //4. 去掉被你设置过"不看他(她)的朋友圈"的好友
                    Thread.sleep(200);
                    list.add("kl3");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //5. 去掉对你设置过"不让他(她)看我的朋友圈"的好友
                    Thread.sleep(100);
                    list.add("kl5");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //6. 去掉被你拉黑和把你拉黑的好友
                    Thread.sleep(100);
                    list.add("k6");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //7. 去掉被微信系统标记为作弊的好友
                    Thread.sleep(300);
                    list.add("kl4");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            }
        });
        try {
            latch.await();
            //latch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //等待所有子任务完成，汇总处理
        //8. 获取好友最近动态再返回

        executor.shutdown();
        return list;
    }


    public static List<String> lastestFeedsByFuture(String wxId) throws ExecutionException, InterruptedException {


        final List<String> list=new ArrayList<>();

        Callable c1 = new Callable(){
            @Override
            public Object call() throws Exception {

                Thread.sleep(100);
                return "kkkkkl";
            }
        };

        Future future1=executor.submit(c1);
        list.add((String) future1.get());
        Callable c2 = new Callable(){
            @Override
            public Object call() throws Exception {

                Thread.sleep(1000);
                String s=null;

                return "kkk1kkl";
            }
        };

        Future future2=executor.submit(c2);

        Callable c3 = new Callable(){
            @Override
            public Object call() throws Exception {

                Thread.sleep(100);
                return "kkkk3kl";
            }
        };

        Future future3=executor.submit(c3);
        Callable c4 = new Callable(){
            @Override
            public Object call() throws Exception {

                Thread.sleep(100);
                return "k3kkkkl";
            }
        };

        Future future4=executor.submit(c4);
        Callable c5 = new Callable(){
            @Override
            public Object call() throws Exception {

                Thread.sleep(300);
                return "kkkk3kl";
            }
        };

        Future future5=executor.submit(c5);


        list.add("jjjjk33333jkkl");
        list.add((String) future2.get());
        list.add((String) future3.get());
        list.add("jjjjkjkkl");
        list.add((String) future4.get());
        list.add((String) future5.get());

        return list;
    }
}
