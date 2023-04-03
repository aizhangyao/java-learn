package com.aiz.juc.lock;


public class MiTest {
    public static void main(String[] args) {
        // 锁的是，当前Test.class
        Test.a();
        Test test = new Test();
        // 锁的是new出来的test对象
        test.b();
    }
}
