package com.aiz.sort;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @Author Yao
 * @Date Create in 8:26 下午 2020/12/16
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sort(a);
        print(a);
    }

    static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

}
