package com.aiz.se.day04.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName ChildGame
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 16:20 2019/10/17
 * @Version 1.0
 */
public class ChildGame {
    /**
     * 5.假设有N个小孩围成一圈，这些小孩从1开始编号，直到报到N,现在假设从1号小孩开始报数，依次类推，每报到M的小孩出列，直到所有的小孩都已出列。
     * 请打印出出列小孩的序列。(数组存放小孩)
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //
        System.out.print("请输入小孩数和需要报的数>");
        //
        int N = sc.nextInt(); //小孩数
        int M = sc.nextInt(); //报数
        //
        int[] result = game(N, M);
        //
        System.out.println("小孩出列的顺序是：\n" + Arrays.toString(result));
        //
        sc.close();
    }

    public static int[] game(int N, int M) {
        // 1.用一个数组保存所有的小孩
        int[] childs = new int[N];
        // 编号
        for (int i = 0; i < childs.length; i++) {
            childs[i] = i + 1;
        }
        // 定义变量保存结果
        int[] result = new int[N];
        // 2. 报数
        int exitCount = 0; // 已出列的小孩个数
        int index = 0; // 报数器
        while (exitCount < N) {
            // 所有小孩 开始报数
            for (int i = 0; i < childs.length; i++) {
                // 判断
                if (childs[i] == 0) {
                    continue;
                }
                // 报数
                index++;
                // 当index报到M时，当前下标的小孩出列[把值改为0]
                if (index == M) {
                    result[exitCount] = childs[i]; // 把出列小孩的编号保存到结果数组中
                    childs[i] = 0; // 已出列小孩的标号重置为0
                    exitCount++; // 出列小孩 数量+1
                    index = 0; // 重置报数器
                }
            }
        }
        //
        return result;
    }

}
