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

    static class MyThread extends Thread{
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

    public static void main(String[] args) {
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

}
/**
 * Ready就写状态
 * Running运行状态
 * Terminated结束状态
 * TimedWaiting按时间等待
 * Waiting等待
 * Blocked阻塞
 */