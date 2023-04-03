package com.aiz.juc.three;


/**
 * @author zhangyao
 */
public class Atomic {
    private static int count;

    public static void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

}