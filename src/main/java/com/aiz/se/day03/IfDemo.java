package com.aiz.se.day03;

import java.util.Scanner;

/**
 * @ClassName IfDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:06 2019/10/15
 * @Version 1.0
 */
public class IfDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 创建对象
        Scanner sc = new Scanner(System.in);
        // 提示用户输入某个整数
        System.out.print("请输入任意整数>");
        // 定变量来接受用户的输入
        int i = sc.nextInt();
        // 判断
        if ((i & 1) == 0) {
            System.out.println(i + " 是一个偶数.");
        } else {
            System.out.println(i + " 是一个奇数.");
        }
        // 释放资源
        sc.close();
    }
}