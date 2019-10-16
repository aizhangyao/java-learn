package com.aiz.se.day03;

import java.util.Scanner;

/**
 * @ClassName ForDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:07 2019/10/15
 * @Version 1.0
 */
public class ForDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);
        //
        System.out.print("Please enter the loop count>");
        //定义一个变量来接受用户的输入
        int loop = sc.nextInt();
        //定义步长
        System.out.print("\nplease enter the step>");
        int step = sc.nextInt();
        //
        for (int i = 0; i < loop; i += step) {
            System.out.println("current i= " + i);
        }
        //
        sc.close();
    }
}