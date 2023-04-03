package com.aiz.annotation;

/**
 * 使用自定义注解
 *
 * @author zhangyao
 */
public class HelloAnnotationClient {

    @HelloAnnotation(value = "Simple Custom Annotation Example")
    public void sayHello() {
        System.out.println("Inside sayHello method..");
    }
}
