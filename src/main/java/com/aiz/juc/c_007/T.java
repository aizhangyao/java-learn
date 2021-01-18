package com.aiz.juc.c_007;

/**
 * @ClassName T
 * @Description 同步和非同步方法是否可以同时调用
 * @Author Administrator
 * @Date Create in 17:52 2020/12/10 0010
 * @Version 1.0
 */
public class T {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end...");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 end...");
    }

    public static void main(String[] args) {
        T t = new T();
        //new Thread(() -> t.m1(), "t1").start();
        //new Thread(() -> t.m2(), "t2").start();

        new Thread(t::m1,"t1").start();
        new Thread(t::m2,"t2").start();

        //1.8之前的写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                t.m1();
            }
        }).start();

    }
}
