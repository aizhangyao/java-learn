package com.aiz.juc;

/**
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:39 2023/2/22
 * @Version 1.0
 */
public class ThreadLocalTest {
    static ThreadLocal tl1 = new ThreadLocal();
    static ThreadLocal tl2 = new ThreadLocal();

    public static void main(String[] args) {
        tl1.set("123");
        tl2.set("456");
        Thread t1 = new Thread(() -> {
            System.out.println("t1:" + tl1.get());
            System.out.println("t1:" + tl2.get());
        });
        t1.start();
        System.out.println("main:" + tl1.get());
        System.out.println("main:" + tl2.get());
    }
}
