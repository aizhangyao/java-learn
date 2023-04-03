package com.aiz.juc.lock;


public class LockOptimization {
    public static void main(String[] args) {

        Object o = new Object();
        for (int i = 0; i < 999; i++) {
            synchronized (o){
                // ...
            }
        }
        // 这时上面的代码会触发锁膨胀
        synchronized (o){
            for (int i = 0; i < 999; i++) {
                // ...
            }
        }
    }
}
