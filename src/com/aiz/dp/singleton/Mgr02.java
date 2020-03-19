package com.aiz.dp.singleton;

/**
 * @ClassName: Mgr02
 * @Description: TODO
 * 和01是一个意思
 * @Author: ZhangYao
 * @Date: Create in 20:44 2020/3/19
 * @Version 1.0
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    private Mgr02() {
    }

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }
}
