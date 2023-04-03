package com.aiz.jvm;

import com.aiz.jvm.tc.HelloWorld;

/**
 * 类的加载
 */
public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = HelloWorld.class.getClassLoader();
        System.out.println(classLoader);
        //1.使用ClassLoader.loadClass()来加载类，不会执行初始化块
        classLoader.loadClass("com.aiz.jvm.tc.T2");

        //2.使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("com.aiz.jvm.tc.T2");

        //3.使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class.forName("com.aiz.jvm.tc.T2", false, classLoader);
    }
}
