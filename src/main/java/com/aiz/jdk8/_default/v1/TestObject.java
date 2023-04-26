package com.aiz.jdk8._default.v1;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestObject
 * @description 继承两个接口的测试类
 * @date Create in 14:25 2023/4/26
 */
public class TestObject implements TestInterface1, TestInterface2 {
    @Override
    public void sameMethod() {
        // 这里也可以选择两个接口中的一个默认实现
        // 如：TestInterface1.super.sameMethod();
        System.out.println("Invoke Object method！");
    }
}