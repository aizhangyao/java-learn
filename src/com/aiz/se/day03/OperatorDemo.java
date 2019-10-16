package com.aiz.se.day03;

/**
 * @ClassName OperatorDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:05 2019/10/15
 * @Version 1.0
 */
public class OperatorDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //定义变量
        int a = 12;
        int b = a++;
        //输出
        System.out.println("a = " + a);//a = 13
        System.out.println("b = " + b);//b = 12

        // "++"运算符
        int c = a++ + ++a;
        System.out.println("c = " + c);//c = 28
        System.out.println("a = " + a);//a = 15

        //
        byte b1 = 12;
        byte b2 = 15;
        byte b3 = (byte) (b1 + b2);//ok
        //b1 = b1 + 2;//error
        b1 += 2;//ok，因为2是整型
        b1++;//ok

        //
        int i = b3;//ok，隐式转换
        //
        byte b4 = (byte) i;//强制转换
    }
}