package com.aiz.juc.c_004;

public class T {
    private static int count = 10;

    public static synchronized void m() {//等同于在方法的代码执行时要synchronized (T.class)
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static synchronized void mm() {
        synchronized (T.class){//考虑一下这里写synchronized (this)是否可以？
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

}
