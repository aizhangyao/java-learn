package com.aiz.juc.c_000;


/**
 * @author zhangyao
 */
public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                // 获取任务
                // 拿到任务，执行任务
                // 没有任务了，让线程休眠
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("基于打断形式结束当前线程");
                    return;
                }
            }
        });
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }

    public static void main3(String[] args) throws InterruptedException {
        // 线程默认情况下， interrupt标记位:false
        System.out.println(Thread.currentThread().isInterrupted());
        // 执行interrupt之后，再次查看打断信息
        Thread.currentThread().interrupt();
        // interrupt标记位:ture
        System.out.println(Thread.currentThread().isInterrupted());
        // 返回当前线程，并归位为false interrupt标记位:ture
        System.out.println(Thread.interrupted());
        // 已经归位了
        System.out.println(Thread.interrupted());
        // =====================================================
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // 处理业务
            }
            System.out.println("t1结束");
        });
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }


    static volatile boolean flag = true;

    public static void main2(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
                // 处理任务
            }
            System.out.println("任务结束");
        });
        t1.start();
        Thread.sleep(500);
        flag = false;
    }


    public static void main1(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(500);
        t1.stop();
        System.out.println(t1.getState());
    }
}
