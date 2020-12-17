package com.aiz.dp.strategy;

/**
 * @ClassName Sorter
 * @Description
 * @Author Yao
 * @Date Create in 5:30 下午 2020/12/16
 * @Version 1.0
 */
public class Sorter {

    /**
     * 选择排序
     * @param arr
     */
    public static void sort(int[] arr) {
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //对猫进行排序
    public static void sort(Cat[] arr) {
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos])==-1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //使用java.lang.Comparable
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j].compareTo(arr[minPos])==-1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
