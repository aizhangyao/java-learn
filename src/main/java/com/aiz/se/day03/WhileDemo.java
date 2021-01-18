package com.aiz.se.day03;

import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName WhileDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:07 2019/10/15
 * @Version 1.0
 */
public class WhileDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //创建Random对象和Scanner对象
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        //提示用户输入一个整数
        System.out.println("请输入1~100之间的任意1个整数>");
        //定义变量
        int input = sc.nextInt();
        //
        boolean exit = false;
        int count = 0;//计算器
        int num = 0;
        //循环
        while (!exit) {
            //记数一次
            count++;
            //产生随机数并判断
            num = r.nextInt(100) + 1;
            System.out.println("当前生成的随机数：" + num);
            if (input == num) {
                System.out.println("终于找到你....");
                //说明随机数刚才是我们指定的整数，则打破循环
                exit = true;
            }
        }
        //输出结果
        System.out.println("经过" + count + "次的循环，终于生成了：" + input);
        sc.close();
    }
}