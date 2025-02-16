package com.aiz.juc.c_000;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @ClassName T2_HowToCreateThread
 * @Description 创建线程的几种方式
 * @Author Administrator
 * @Date Create in 15:10 2020/12/10 0010
 * @Version 1.0
 */
public class T2_HowToCreateThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    public void myRunMethod(){
        // 匿名内部类方式：
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("MyRunnable!");
            }
        });
        // lamdba方式：
        Thread thread2 = new Thread(()->{
                System.out.println("MyRunnable!");
        });
    }

    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall!");
            return "success";
        }
    }

    //启动线程的5种方式
    public static void main(String[] args) {
        new MyThread().start();

        new Thread(new MyRun()).start();

        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start();

        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            System.out.println("Hello ThreadPool!");
        });
        service.shutdown();
    }

}
/**
 *
 */