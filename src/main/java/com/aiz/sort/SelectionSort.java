package com.aiz.sort;

/**
 * @ClassName SelectionSort
 * @Description 选择排序
 * @Author Yao
 * @Date Create in 10:03 下午 2020/12/16
 * @Version 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        sort(a);
        print(a);
    }

    static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = arr[j]<arr[minPos]?j:minPos;
            }
            swap(arr,i,minPos);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

}
