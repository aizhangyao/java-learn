package com.aiz.se.day02;

/**
 * @ClassName CharDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 22:56 2019/10/14
 * @Version 1.0
 */
public class CharDemo {
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //定义字符变量
        char c1 = 'a';
        char c2 = '\"';
        char c3 = '\u6211';
        //分别输出以上3个字符
        System.out.println("c1的值："+c1);//a
        System.out.println("c2的值："+c2);//"
        System.out.println("c3的值："+c3);//我
        //分别输出这3个字符的整数形式
        int i1 = c1;//隐式转换
        int i2 = c2;
        int i3 = c3;
        //
        System.out.println("变量i1："+i1);//97
        System.out.println("变量i2："+i2);//34
        System.out.println("变量i3："+i3);//25105

    }
}