package com.aiz.dp.singleton;

/**
 * @ClassName: Mgr08
 * @Description: TODO
 * 不仅可以解决线程同步，还可以防止反序列化。
 * @Author: Administrator
 * @Date: Create in 21:27 2020/3/19
 * @Version 1.0
 */
public enum Mgr08 {
    INSTANCE;

    public void m() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
