package com.aiz.se.day03;

import java.util.Scanner;

/**
 * @ClassName SwitchDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:06 2019/10/15
 * @Version 1.0
 */
public class SwitchDemo {

    /**
     * 案例：用户从键盘上输入年份和月份，然后判断此年月最大有多少天。
     * @param args
     */
    public static void main(String[] args) {
        //创建对象
        Scanner sc = new Scanner(System.in);
        //提示用户输入年份和月份
        System.out.println("请输入年份和月份>");
        //定义变量保存用户的输入
        int year = sc.nextInt();
        int month = sc.nextInt();
        //在定义一个变量，用来保存最大天数
        int max = 0;//给一个默认值为0
        //
        switch (month) {
            case 1:
            case 3:
            case 7:
            case 8:
            case 10:
            case 12:
                max = 31;
                break;
            case 6:
            case 4:
            case 9:
            case 11:
                max = 30;
                break;
            case 2:
                max = 28;
                //要进一步判断是否为闰年
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    //是闰年的话，则再加1
                    max += 1;
                }
                break;
            default:
                System.out.println("unknown month!");
                return;
        }//end of switch
        //输出结果
        System.out.println(year + "年" + month + "月最多是" + max + "天。");
    }//end of main method

}