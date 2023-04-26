package com.aiz.jdk8._default.v2;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestInterface
 * @description 测试接口
 * @date Create in 14:31 2023/4/26
 */
public interface TestInterface {
    default void sameMethod() {
        System.out.println("Invoke TestInterface Method！");
    }
}