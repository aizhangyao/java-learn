package com.aiz.se.day03.hw;

import java.util.Scanner;

/**
 * @ClassName Exercises
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:06 2019/10/17
 * @Version 1.0
 */
public class Exercises {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //factorial();//阶乘
        //findSxhNumber();//100内所有水仙花数
        printPrime();//200内所有质数
    }

    // 阶乘
    public static void factorial() {
        System.out.print("Please enter a number>");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.print(num + "! = ");
        for (int i = num; i > 1; i--) {
            System.out.print(i + "*");
        }
        System.out.print(1);

        sc.close();
    }

    // 找出1000以内的所有水仙花数
    public static void findSxhNumber() {
        System.out.println("1000以内的所有水仙花数：");
        int a = 0, b = 0, c = 0;
        for (int num = 100; num <= 999; num++) {
            // 153
            a = num / 100;// 百位
            b = (num % 100) / 10;// 十位
            c = num % 10;// 个位
            if (num == a * a * a + b * b * b + c * c * c) {
                System.out.println(num);
            }
        }
    }

    // 判断质数
    public static int isPrimeN(int num) {
        int i, j;
        j = (int) Math.sqrt(num);
        for (i = 2; i <= j; i++) {
            if (num % i == 0)
                break;
        }
        if (i > j) {
            return 1;
        } else {
            return 0;
        }
    }

    // 找出200以内所有的质数,要求：每行最多输出10个。
    public static void printPrime() {
        System.out.println("找出200以内所有的质数，并打印出来，要求：每行最多输出10个：");
        int count = 0;
        for (int i = 2; i <= 200; i++) {
            if (isPrimeN(i) == 1) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }

}