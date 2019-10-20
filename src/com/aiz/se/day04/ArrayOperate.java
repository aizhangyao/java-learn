package com.aiz.se.day04;

/**
 * @ClassName ArrayOperate
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 17:20 2019/10/17
 * @Version 1.0
 */
public class ArrayOperate {
    /*
     * 从数组arr中起始位置查找指定元素target,如果找到，则返回第一次出现的位置，如果没有找到，则返回-1.
     * @param arr被查找的数组
     * @param target 要查找的元素
     * @return
     */
    public static int find(int[] arr, int target) {
        return find(arr, 0, target);
    }

    public static int find(int[] arr, int start, int target) {
        // 1.定义变量，用来保存下标
        int index = -1;
        // 2.算法
        for (int i = start; i < arr.length; i++) {
            // 判断
            if (target == arr[i]) {
                // 找到了，保存下标
                index = i;
                break;
            }
        }
        // 3.返回
        return index;
    }


    /*
     * 在数组arr中的指定位置pos处，插入新元素element,并返回一个新的数组
     * @param arr
     * @param pos
     * @param element
     * @return
     */
    public static int[] insert(int[] arr, int pos, int element) {
        //判断位置的有效性
        if (pos < 0) {
            pos = 0;
        } else if (pos > arr.length) {
            pos = arr.length;
        }
        //定义变量
        int[] narr = new int[arr.length + 1];
        //算法
        //把pos位置之前的元素COPY到新数组中
        System.arraycopy(arr, 0, narr, 0, pos);
        //把pos位置之后的元素COPY到新数组中
        System.arraycopy(arr, pos, narr, pos + 1, arr.length - pos);
        //把元素赋值到pos位置处
        narr[pos] = element;
        //返回
        return narr;
    }

    /*
     * 从数组中arr中删除指定元素target，如果没有这个元素，则返回与原数组相同的数组
     */
    public static int[] delete(int[] arr, int target) {
        int[] narr = new int[arr.length + 1];
        return narr;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = new int[]{100, 45, 34, 3, 6, 45, 188, 9, 100};
        int element = 100;
        int i = find(arr, element);
        System.err.println(i);

        //测试插入
    }

}