package com.aiz.se.day04;

/**
 * @ClassName ArrayDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:38 2019/10/16
 * @Version 1.0
 */
public class ArrayDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //创建数组
        int[] iarr = new int[8];
        String[] name = new String[5];
        //把这两个数组的元素打印出来
        for (int i = 0; i < iarr.length; i++) {
            System.out.print(iarr[i] + " ");
        }
        System.out.println();

        for (String e : name) {
            System.out.print(e + " ");
        }
        System.out.println();

        //再创建一个数组
        int[] jarr = new int[]{1, 5, 67, 45, 65, 7, 89, 0, 4, 34};
        for (int e : jarr) {
            System.out.print(e + " ");
        }
        System.out.println();
        int[] karr = new int[10];
        for (int i = 0; i < karr.length; i++) {
            karr[i] = 2 * i + 1;
        }
        for (int e : karr) {
            System.out.print(e + ", ");
        }
        System.out.println();

    }
}