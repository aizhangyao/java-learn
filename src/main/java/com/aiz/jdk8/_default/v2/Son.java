package com.aiz.jdk8._default.v2;

/**
 * @author ZhangYao
 * @version 1.0
 * @className Son
 * @description 子类
 * @date Create in 14:32 2023/4/26
 */
public class Son extends Father implements TestInterface {
    @Override
    public void sameMethod() {
        System.out.println("Invoke Son Method！");
    }
}