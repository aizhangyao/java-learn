package com.aiz.juc.three;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName Cas
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 10:56 2023/2/22
 * @Version 1.0
 */
public class Cas {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main_1(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }


    public static void main(String[] args) {
        AtomicStampedReference<String> reference = new AtomicStampedReference<>("AAA", 1);
        String oldValue = reference.getReference();
        int oldVersion = reference.getStamp();
        boolean b = reference.compareAndSet(oldValue, "B", oldVersion, oldVersion + 1);
        System.out.println("修改1版本的:" + b);
        boolean c = reference.compareAndSet("B", "C", 1, 1 + 1);
        System.out.println("修改2版本的:" + c);
    }

}
