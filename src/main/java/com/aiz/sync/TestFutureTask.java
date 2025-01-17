package com.aiz.sync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TestFutureTask {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("任务开始执行......");
            Thread.sleep(2000);
            System.out.println("任务执行完毕......");
            return "OK!";
        });
        // 构建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // 构建线程池
        threadPool.execute(futureTask);

        // futureTask提供了run方法，一般不会自己去调用run方法，让线程池去执行任务，由线程池去执行run方法
        // run方法在执行时，是有任务状态的。任务已经执行了，再次调用run方法无效的。
        // 如果希望任务可以反复被执行，需要去调用runAndReset方法
        futureTask.run();

        // 对返回结果的获取，类似阻塞队列的poll方法
        // 如果在指定时间内，没有拿到方法的返回结果，直接扔TimeoutException
//        try {
//            String s = futureTask.get(3000, TimeUnit.MICROSECONDS);
//            System.out.println("返回结果:" + s);
//        } catch (Exception e) {
//            System.out.println("异常返回:" + e.getMessage());
//            e.printStackTrace();
//        }

        // 对返回结果的获取，类似阻塞队列的take方法，死等结果
//        try {
//            String s = futureTask.get();
//            System.out.println("任务结果:" + s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        // 对任务状态的控制
        System.out.println("任务结束了么?:" + futureTask.isDone());
        Thread.sleep(1000);
        System.out.println("任务结束了么?:" + futureTask.isDone());
        Thread.sleep(1000);
        System.out.println("任务结束了么?:" + futureTask.isDone());
    }
}
