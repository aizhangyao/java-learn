package com.aiz.se.day04;

import java.util.Arrays;

/**
 * @ClassName Array2D
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 17:21 2019/10/17
 * @Version 1.0
 */
public class Array2D {

    /*
     * 此方法产生一个规则的二维数组，根据用户的指定的行和列
     * @param rows
     * @param cols
     */
    public static int[][] regular2d(int rows, int cols) {

        int[][] result = new int[rows][cols];

        //
        return result;
    }

    /*
     * 此方法产生一个不规则的二维数组，它的列是由行得到的。
     * @param rows
     */
    public static int[][] unRegular2d(int rows) {
        // 此时只初始化了二维数组本身
        int[][] result = new int[rows][];
        // 进一步初始化它的每一个元素【一维数组】
        for (int i = 0; i < result.length; i++) {
            // 初始化一维数组
            result[i] = new int[i + 1];
        }
        // ..

        // 返回
        return result;
    }

    /*
     * 杨辉三角
     */
    public static int[][] yangHuiSanjiao(int rows) {
        // 此时只初始化了二维数组本身
        int[][] result = new int[rows][];
        // 进一步初始化它的每一个元素【一维数组】
        for (int i = 0; i < result.length; i++) {
            // 初始化一维数组
            result[i] = new int[i + 1];
        }
        // ..杨辉三角..
        result[0][0] = 1;
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                //
                if (j == 0 || j == i) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                }
            }
        }
        // 返回
        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = regular2d(5, 7);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }

        System.out.println("--华丽的分割线---");
        int[][] arr2 = unRegular2d(6);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--杨辉三角---");
        int[][] arr3 = yangHuiSanjiao(9);
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }

}