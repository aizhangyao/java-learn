package com.aiz.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义注解测试
 *
 * @author zhangyao
 */
public class HelloAnnotationTest {
    public static void main(String[] args)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        HelloAnnotationClient helloAnnotationClient = new HelloAnnotationClient();
        Method method = helloAnnotationClient.getClass().getMethod("sayHello", null);
        if (method.isAnnotationPresent(HelloAnnotation.class)) {
//            HelloAnnotation helloAnnotation = method.getAnnotation(HelloAnnotation.class);
//            //Get value of custom annotation
//            System.out.println("Value : " + helloAnnotation.value());
//            //Invoke sayHello method
//            method.invoke(helloAnnotationClient);
        }
    }
}
