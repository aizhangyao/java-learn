package com.aiz.jdk8._default.v1;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestInterface1
 * @description 测试接口 1
 * @date Create in 14:24 2023/4/26
 */
public interface TestInterface1 {
    default void sameMethod() {
        System.out.println("Invoke TestInterface1 method！");
    }
}