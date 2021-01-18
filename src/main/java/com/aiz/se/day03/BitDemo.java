package com.aiz.se.day03;

/**
 * @ClassName BitDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:05 2019/10/15
 * @Version 1.0
 */
public class BitDemo {
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //定义变量
        int a = 0b11101;//二进制
        int b = 0x4c;//十六进制
        int c = 0112;// 八进制

        //打印输出
        System.out.println("a=" + a);//a=29
        System.out.println("b=" + b);//b=76
        System.out.println("c=" + c);//c=74
        //
        int k = a & b;//12
        System.out.println(a + "&" + b + "=" + k);
        //
        k = a | b;//93
        System.out.println(a + "|" + b + "=" + k);
        //
        k = a ^ b;//81
        System.out.println(a + "^" + b + "=" + k);
        //
        k = c >> 2;//18
        System.out.println(c + ">>2=" + k);
        //无符号右移2位
        k >>>= 2;
        System.out.println("k=" + k);

        //
        System.out.println("交换前:");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        //
        k = a ^ b ^ b;
        //
        System.out.println("k=" + k);
        //交换a和b
        a^=b;//a = a ^ b;
        b^=a;//b = b ^ a ^ b;相当于a异或了b两次，回到a
        a^=b;//a = a ^ b ^ a;相当于b异或了a两次，回到b
        System.out.println("交换后:");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}