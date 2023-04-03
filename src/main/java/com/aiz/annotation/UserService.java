package com.aiz.annotation;


/**
 * @author zhangyao
 */
@FunctionalInterface
public interface UserService {
    /**
     * 抽象方法
     */
    void getUser(Long userId);

    /**
     * 默认方法，可以用多个默认方法
     */
    default void setUser() {
    }

    /**
     * 静态方法
     */
    static void saveUser() {
    }

    /**
     * 覆盖Object中的equals方法
     */
    @Override
    boolean equals(Object obj);
}
