package com.aiz.dp.singleton;

/**
 * @ClassName: Mgr01
 * @Description: TODO
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM会保证线程安全。
 * 简单实用，推荐使用！
 * 唯一缺点：不管是否用到，类装载时就会完成实例化。（你不使用他，装载他干吗？？）
 * @Author: ZhangYao
 * @Date: Create in 20:06 2020/3/19
 * @Version 1.0
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
