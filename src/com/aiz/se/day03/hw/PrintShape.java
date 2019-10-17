package com.aiz.se.day03.hw;

import java.util.Scanner;

/**
 * @ClassName PrintShape
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:04 2019/10/17
 * @Version 1.0
 */
public class PrintShape {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //printSolidRightTriangle();//实心直角三角形
        //printSolidRegularTriangle();//实心正三角形
        printHollowDiamond();//空心菱形
    }

    // 打印实心直角三角形
    public static void printSolidRightTriangle() {
        System.out.println("输入高度>");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        sc.close();
    }

    // 打印实心正三角形
    public static void printSolidRegularTriangle() {
        // 每行2*height-1个*
        System.out.println("输入高度>");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        // i代表第几行
        for (int i = 1; i <= height; i++) {
            // 输出空格，height-i个空格
            for (int k = 0; k < height - i; k++) {
                System.out.print(' ');
            }
            // 输出*，2*i-1个*
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print('*');
            }
            // 换行
            System.out.println();
        }
        sc.close();
    }

    // 打印空心菱形
    public static void printHollowDiamond() {
        System.out.println("输入高度>");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        // height=高度为顶尖到底座高度，一共2*height-1行，i代表第几行
        for (int i = 1; i <= 2 * height - 1; i++) {
            // 打印前部分空格，每行Math.abs(i-height)个空格
            for (int j = 0; j < Math.abs(i - height); j++) {
                System.out.print(' ');
            }
            // 打印每行前半部分*
            System.out.print('*');
            if (i == 1) {
                System.out.println();
            }
            // 打印中间空格2*height-2*Math.abs(i-height)-3个，i需满足(i>1&&i<2*height-1),即非首行和尾行
            if (i > 1 && i < 2 * height - 1) {
                for (int k = 0; k < 2 * height - 2 * Math.abs(i - height) - 3; k++) {
                    System.out.print(' ');
                }
                // 打印每行后半部分*
                System.out.println('*');
            }
        }
        sc.close();
    }

}