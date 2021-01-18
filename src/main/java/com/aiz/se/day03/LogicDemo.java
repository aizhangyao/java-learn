package com.aiz.se.day03;

import java.util.Scanner;

/**
 * @ClassName LogicDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:05 2019/10/15
 * @Version 1.0
 */
public class LogicDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //创建Scanner变量[对象]
        Scanner sc = new Scanner(System.in);
        //提示用户输入一个整数
        System.out.print("请输入任意整数：");
        //定义变量来接受用户的输入
        int i = sc.nextInt();
        //
        boolean b = (i > 5) && (i % 5 == 0);
        //打印输出
        System.out.println("结果：" + b);
        //释放资源
        sc.close();
    }
}