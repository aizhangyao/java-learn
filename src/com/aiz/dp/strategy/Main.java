package com.aiz.dp.strategy;

import java.util.Arrays;

/**
 * @ClassName: Main
 * @Description: TODO
 * @Author: ZhangYao
 * @Date: Create in 23:39 2020/3/21
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //int[] a = {9,2,3,5,7,1,4};
        //Cat[] a = {new Cat(1,2),new Cat(5,5),new Cat(3,3)};
        Dog[] a = {new Dog(2),new Dog(3),new Dog(1)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
