package com.aiz.dp.singleton;

/**
 * @ClassName: Mgr06
 * @Description: TODO
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，却也带来了线程不安全的问题
 * 可以通过synchronized解决，但却带来了效率下降
 * @Author: ZhangYao
 * @Date: Create in 21:17 2020/3/19
 * @Version 1.0
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;//JIT

    private Mgr06() {

    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
//                    try{
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    INSTANCE = new Mgr06();
                }
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
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
