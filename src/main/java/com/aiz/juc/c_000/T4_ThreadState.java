package com.aiz.juc.c_000;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T4_ThreadState
 * @Description 线程状态
 * @Author Administrator
 * @Date Create in 17:20 2020/12/10 0010
 * @Version 1.0
 */
public class T4_ThreadState {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main1(String[] args) {
        Thread t = new MyThread();
        //怎样得到这个线程的状态呢？就是通过getState()这个方法
        System.out.println(t.getState());//NEW状态

        t.start();//到这start()完了之后呢是RUNNABLE的状态

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //然后join之后，结束了是一个TERMINATED状态
        System.out.println(t.getState());
    }

    /**
     * 六种状态
     */
    public static void main2(String[] args) throws InterruptedException {
        // NEW
        Thread t1 = new Thread();
        System.out.println(t1.getState());

        // RUNNABLE
        Thread t2 = new Thread(() -> {
            while (true) {
            }
        });
        t2.start();
        Thread.sleep(500);
        System.out.println(t2.getState());

        // BLOCKED
        Object obj3 = new Object();
        Thread t3 = new Thread(() -> {
            // t3线程拿不到锁资源，导致变为BLOCKED状态
            synchronized (obj3) {
            }
        });
        // main线程拿到obj的锁资源
        synchronized (obj3) {
            t3.start();
            Thread.sleep(500);
            System.out.println(t3.getState());
        }

        // WAITING
        Object obj4 = new Object();
        Thread t4 = new Thread(() -> {
            synchronized (obj4) {
                try {
                    obj4.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t4.start();
        Thread.sleep(500);
        System.out.println(t4.getState());

        // TIMED_WAITING
        Thread t5 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t5.start();
        Thread.sleep(500);
        System.out.println(t5.getState());

        // TERMINATED
        Thread t6 = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t6.start();
        Thread.sleep(1000);
        System.out.println(t6.getState());
    }

    public static void main_m1(String[] args) {
        // 获取当前线程的方法
        Thread main = Thread.currentThread();
        System.out.println(main);
        // Thread[#1,main,5,main]
        // "Thread[" + getName() + "," + getPriority() + "," + group.getName() + "]";
    }

    public static void main_m2(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        t1.setName("模块-功能-计数器");
        t1.start();
    }

    public static void main_m3(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t1:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                System.out.println("t2:" + i);
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t2.start();
        t1.start();
    }

    public static void main_m4(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i == 50) {
                    Thread.yield();
                }
                System.out.println("t1:" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t2:" + i);
            }
        });
        t2.start();
        t1.start();
    }


    public static void main_m5(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis());
    }


    public static void main_m6(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 1) {
                try {
                    t1.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main_7(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
    }

}
/**
 * Ready就绪状态
 * Running运行状态
 * Terminated结束状态
 * TimedWaiting按时间等待
 * Waiting等待
 * Blocked阻塞
 */