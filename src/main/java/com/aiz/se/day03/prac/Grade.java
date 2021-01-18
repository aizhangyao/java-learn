package com.aiz.se.day03.prac;

import java.util.Scanner;

/**
 * @ClassName Grade
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:37 2019/10/17
 * @Version 1.0
 */
public class Grade {
    /**
     * 请根据如下要求编写一个程序
     * 从键盘输入学员的成绩，根据成绩打印出相依的等级，成绩和等级的关系是：
     * >= 95 ,A+
     * [90,95),A
     * [80,90),B
     * [70,80),C
     * [60,70),D
     * <60,-),E
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学员成绩：");
        Double grade = sc.nextDouble();
        if (grade >= 95) {
            System.out.println("该学员成绩等级为A+");
        } else if (grade >= 90 && grade < 95) {
            System.out.println("该学员成绩等级为A");
        } else if (grade >= 80 && grade < 90) {
            System.out.println("该学员成绩等级为B");
        } else if (grade >= 70 && grade < 80) {
            System.out.println("该学员成绩等级为C");
        } else if (grade >= 60 && grade < 70) {
            System.out.println("该学员成绩等级为D");
        } else {
            System.out.println("该学员成绩等级为E");
        }
        sc.close();
    }
}