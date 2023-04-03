package com.aiz.jvm;

/**
 * @ClassName T
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:34 2023/2/24
 * @Version 1.0
 */
public class T {
    public static int count = 2;
    static T t = new T();

    private T(){
        count++;
    }
}
