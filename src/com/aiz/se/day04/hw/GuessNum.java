package com.aiz.se.day04.hw;

import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName GuessNum
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 15:27 2019/10/17
 * @Version 1.0
 */
public class GuessNum {
    /**
     * 3.猜数字游戏:由程序生成一个1~100以内的随机数，然后让用户猜，如果用户所猜的数比答案大，则提示：大了。如果用户所猜的数比答案小，则提示：小了。
     * 直到猜对为止，并输出用户猜的次数。
     *
     * @param args
     */
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        System.out.println("系统生成的随机数是" + num);
        System.out.println("请输入1~100之间的任意数字:");
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int count = 0;
        do {
            input = sc.nextInt();
            count++;
            if (num == input) {
                System.out.println("猜对了,一个猜了" + count + "次！");
            } else if (num < input) {
                System.out.println("大了");
            } else {
                System.out.println("小了");
            }
        } while (num != input);
    }

}