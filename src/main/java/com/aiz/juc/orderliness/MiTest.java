package com.aiz.juc.orderliness;

/**
 * @ClassName MiTest
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 13:12 2023/2/22
 * @Version 1.0
 */
public class MiTest {
    static int a, b, x, y;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次，x = " + x + ",y = " + y);
            }
        }
    }


    private static volatile MiTest test;

    private MiTest() {
    }

    public static MiTest getInstance() { // B
        if (test == null) {
            synchronized (MiTest.class) {
                if (test == null) {
                    // A , 开辟空间，test指向地址，初始化
                    test = new MiTest();
                }
            }
        }
        return test;
    }
}
