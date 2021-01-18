package com.aiz.se.day04;

/**
 * @ClassName MethodDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:36 2019/10/16
 * @Version 1.0
 */
public class MethodDemo {

    // A.判断一个整数是否是质数
    public static int isPrime(int num) {// 是质数返回1，不是返回0
        int i, j;
        j = (int) Math.sqrt(num);
        for (i = 1; i < j; i++) {
            if (num % i == 0) {
                break;
            }
        }
        if (i > j) {
            return 1;
        } else {
            return 0;
        }
    }

    // B.求两个浮点数之和
    public static double add(double a, double b) {
        return a + b;
    }

    // C.获取给定整数的二进制字符串表示形式
    public static String toBinaryString(int num) {
        String istr = Integer.toBinaryString(num);
        return istr;
    }

    // D.打印输出指定上限范围内的所以质数
    public static void printPrime(int max) {
        for (int i = 2; i <= max; i++) {
            if (isPrime(i) == 1) {
                System.out.println(i + " ");
            }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(toBinaryString(9));
    }

}