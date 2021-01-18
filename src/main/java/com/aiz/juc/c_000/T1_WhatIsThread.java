package com.aiz.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T1_WhatIsThread
 * @Description 什么叫线程？
 * @Author Administrator
 * @Date Create in 14:34 2020/12/10 0010
 * @Version 1.0
 */
public class T1_WhatIsThread {

    private static class T1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try{
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //new T1().run();
        new T1().start();
        for (int i = 0; i < 10; i++) {
            try{
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }

}
/**
 * 以上程序可以看到"T1"和"Main"交替输出。
 */