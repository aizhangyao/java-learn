package com.aiz.jdk8.lambda;

/**
 * @author ZhangYao
 * @version 1.0
 * @className Tester
 * @description Test Lambda
 * @date Create in 15:02 2023/4/26
 */
public class Tester {
    public static void main(String[] args) {
        // java 8
        MyLambdaInterface blockOfCode = (s) -> System.out.println(s);

        // java 7
        MyLambdaInterface myInterface = new MyInterfaceImpl();
    }
}
