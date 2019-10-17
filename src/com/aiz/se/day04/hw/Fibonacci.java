package com.aiz.se.day04.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Fibonacci
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 15:14 2019/10/17
 * @Version 1.0
 */
public class Fibonacci {
    /**
     * 2.请设计一个方法，根据用户指定的长度，来生产一个存放了指定长度的斐波那契数列值。(Fibonacci)
     * 如：长度为10的数列为下：
     * 1 1 2 3 5 8 13 21 34 55
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入长度>");
        //
        int n = sc.nextInt();
        //
        long[] result = fibonacci(n);
        //
        System.out.println(Arrays.toString(result));
        //
        sc.close();
    }

    /**
     * @param length
     * @return
     */
    public static long[] fibonacci(int length) {
        //
        if (length <= 0) {
            return null;
        }
        // 创建变量
        long[] result = new long[length];
        //
        if (length == 1) {
            result[0] = 1;
            return result;
        } else {
            // 填充元素值
            result[0] = 1;
            result[1] = 1;
            for (int i = 2; i < result.length; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
            // 返回
            return result;
        }
    }
}