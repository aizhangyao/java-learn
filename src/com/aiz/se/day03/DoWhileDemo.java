package com.aiz.se.day03;

import java.util.Scanner;

/**
 * @ClassName DoWhileDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:07 2019/10/15
 * @Version 1.0
 */
public class DoWhileDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //定义变量
        Scanner sc = new Scanner(System.in);
        //
        int choice = -1;//记录用户的选择
        //
        do {
            // 输出可供用户选择的菜单
            System.out.println("*******************");
            System.out.println("*1 ->看电影       *");
            System.out.println("*2 ->写代码       *");
            System.out.println("*3 ->玩游戏       *");
            System.out.println("*0 ->退出         *");
            // 提供用户选择
            System.out.println("请选择>");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("欢迎来到电影院！");
                    break;
                case 2:
                    System.out.println("欢迎来到实验室！");
                    break;
                case 3:
                    System.out.println("欢迎来到网吧！");
                    break;
                case 0:
                    System.out.println("您已退出！");
                    break;
                default:
                    System.out.println("警告，输入有误！");
            }
        } while (choice != 0);
        sc.close();
        System.out.println("程序结束...");
    }
}