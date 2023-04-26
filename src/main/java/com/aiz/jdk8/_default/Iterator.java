package com.aiz.jdk8._default;

/**
 * @author ZhangYao
 * @version 1.0
 * @className Iterator
 * @description 接口默认方法
 * @date Create in 14:19 2023/4/26
 */
public interface Iterator<E> {
    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
