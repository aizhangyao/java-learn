package com.aiz.annotation;


/**
 * @author zhangyao
 */
@MyInherited
public class MyInheritedTestA {
    public static void main(String[] args) {
        System.out.println(MyInheritedTestA.class.getAnnotation(MyInherited.class));
        System.out.println(MyInheritedTestB.class.getAnnotation(MyInherited.class));
        System.out.println(MyInheritedTestC.class.getAnnotation(MyInherited.class));
    }
}
