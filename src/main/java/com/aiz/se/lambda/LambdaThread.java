package com.aiz.se.lambda;

/**
 * @ClassName LambdaThread
 * @Description Lambda表达式简化线程(只用一次)的使用
 * @Author ZhangYao
 * @Date Create in 0:01 2020/1/6
 * @Version 1.0
 */
public class LambdaThread {
    //静态内部类
    static class InnerThread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("喝酸奶");
            }
        }
    }

    public static void main(String[] args) {
        //静态内部类
        new Thread(new InnerThread1()).start();

        //局部内部类
        class InnerThread2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("喝酸奶");
                }
            }
        }
        new Thread(new InnerThread2()).start();

        //匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("喝酸奶");
                }
            }
        }).start();

        //jdk8使用lambda简化 省略接口名和方法名
        new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    System.out.println("喝酸奶");
                }
            }
        ).start();

    }
}