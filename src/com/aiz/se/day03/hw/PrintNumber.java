package com.aiz.se.day03.hw;

/**
 * @ClassName PrintNumber
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:04 2019/10/17
 * @Version 1.0
 */
public class PrintNumber {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //printNumber1();
        printNumber2();
    }

    // 打印输出1111111*111111=12345654321
    public static void printNumber1() {
        long num = 1L;
        for (int i = 0; i < 9; i++) {
            System.out.println(num + "*" + num + "=" + num * num);
            num = num * 10 + 1;
        }
    }

    // 打印输出123456789*8+9=987654321
    public static void printNumber2() {
        int num = 1;
        final int BASE = 8;
        for (int i = 0; i < 9; i++) {
            System.out.println(num + "*" + BASE + "+" + num % 10 + "="
                    + (num * BASE + num % 10));
            num = num * 10 + num % 10 + 1;
        }
    }

}