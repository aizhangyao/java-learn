package com.aiz.leetcode;


import java.util.Stack;

public class T42 {

    public static int trap(int[] height) {
        /**
         * 动态规划
         */
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        // n位置左边最大的
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // n位置右边最大的
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 0; i < n; ++i) {
            // 左边或者右边最矮的 和 当前位置的 高度差
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

    public static int trap_1(int[] height) {
        Stack<Integer> stack = new Stack<>();


        return 0;
    }

    public static void main(String[] args) {
        int[] height_1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height_1));

        int[] height_2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height_2));
        // 6
        // 9
    }
}
