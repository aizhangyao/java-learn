package com.aiz.jdk8.function;

import java.util.function.Function;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestFunction
 * @description TestFunction
 * @date Create in 15:21 2023/4/26
 */
public class TestFunction {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        // "123"
        backToString.apply("123");
    }
}
