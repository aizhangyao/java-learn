package com.aiz.jdk8._default;

/**
 * @author ZhangYao
 * @version 1.0
 * @className Collection
 * @description 改造 Collection 接口
 * @date Create in 14:21 2023/4/26
 */
public interface Collection {
    int size(); // an abstract method

    default boolean isEmpty() {
        return size() == 0;
    }
}