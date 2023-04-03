package com.aiz.juc.visibility;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockTest
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 12:51 2023/2/22
 * @Version 1.0
 */
public class LockTest {
    private static boolean flag = true;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
                lock.lock();
                try {
                    //...
                } finally {
                    lock.unlock();
                }
            }
            System.out.println("t1线程结束");
        });
        t1.start();
        Thread.sleep(10);
        flag = false;
        System.out.println("主线程将flag改为false");
    }

}
