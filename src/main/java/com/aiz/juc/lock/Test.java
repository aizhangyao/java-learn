package com.aiz.juc.lock;

public class Test {
    public static synchronized void a() {
        System.out.println("1111");
    }

    public synchronized void b() {
        System.out.println("2222");
    }

}
