package com.aiz.se.lambda;

/**
 * @ClassName StartRun
 * @Description 启动一个线程的一种方法
 * @Author ZhangYao
 * @Date Create in 23:55 2020/1/5
 * @Version 1.0
 */
public class StartRun implements Runnable {
    /**
     * 线程入口
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("喝酸奶");
        }
    }

    public static void main(String[] args) {
        new Thread(new StartRun()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println("吃爆米花");
        }
    }

}