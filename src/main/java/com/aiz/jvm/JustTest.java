package com.aiz.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.Properties;

/**
 * @ClassName JustTest
 * @Description 打印对象头
 * @Author ZhangYao
 * @Date Create in 11:22 2023/2/21
 * @Version 1.0
 */
public class JustTest {

    //JOL = Java Object Layout //Open JDK

    public static class T {
        private int a;
    }

    public static void main_1(String[] args) {
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());


//        // 比较加锁与锁释放
//        synchronized (t){
//            System.out.println(ClassLayout.parseInstance(t).toPrintable());
//        }
//        System.out.println(ClassLayout.parseInstance(t).toPrintable());


//        // 查看hashCode存储位置
//        t.hashCode();
//        System.out.println(ClassLayout.parseInstance(t).toPrintable());

    }

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

}