package com.aiz.dp.singleton;

/**
 * @ClassName: Mgr05
 * @Description: TODO
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，却也带来了线程不安全的问题
 * 可以通过synchronized解决，但却带来了效率下降
 * @Author: ZhangYao
 * @Date: Create in 21:11 2020/3/19
 * @Version 1.0
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {

    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
