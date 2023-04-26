package com.aiz.jdk8.lambda;

/**
 * @author ZhangYao
 * @version 1.0
 * @className MyInterfaceImpl
 * @description MyInterfaceImpl
 * @date Create in 15:04 2023/4/26
 */
public class MyInterfaceImpl implements MyLambdaInterface {
    @Override
    public void doSomeShit(String s) {
        System.out.println(s);
    }
}
