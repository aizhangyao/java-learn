package com.aiz.juc.visibility;

/**
 * @ClassName MiTest
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:58 2023/2/22
 * @Version 1.0
 */
public class MiTest {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
                synchronized (MiTest.class) {
                    //...
                }
                System.out.println(111);
            }
            System.out.println("t1线程结束");
        });
        t1.start();
        Thread.sleep(10);
        flag = false;
        System.out.println("主线程将flag改为false");
    }

}
