package com.aiz.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName HeightChecker
 * @Description https://leetcode-cn.com/problems/height-checker/
 * @Author Administrator
 * @Date Create in 20:12 2020/6/30 0030
 * @Version 1.0
 */
public class HeightChecker {
    /**
     * 我自己写的
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        if (heights.length == 0 || heights.length > 100) {
            return -1;
        }
        int num = 0;
        int[] hasOrders = Arrays.copyOf(heights, heights.length);
        //排序
        Arrays.sort(hasOrders);
        //统计
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != hasOrders[i]) {
                num++;
            }
        }
        return num;
    }

    /**
     * 别人家的孩子
     *
     * @param heights
     * @return
     */
    public int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums_1 = new int[]{1, 1, 4, 2, 1, 3};
        int[] nums_2 = new int[]{5, 1, 2, 3, 4};
        int[] nums_3 = new int[]{1, 2, 3, 4, 5};

        HeightChecker hc = new HeightChecker();
        System.out.println(hc.heightChecker(nums_1));//3
        System.out.println(hc.heightChecker(nums_2));//5
        System.out.println(hc.heightChecker(nums_3));//0

        System.out.println(hc.heightChecker2(nums_1));//3
        System.out.println(hc.heightChecker2(nums_2));//5
        System.out.println(hc.heightChecker2(nums_3));//0
    }
}
/**
 * 个人即时感悟--2020/6/30
 * 非递减-->也就是递增排序
 * 所以复制一个数组 给数组先排序 然后统计每一位置不同数量
 *
 * 我的答案可能有点难看，看到评论区有O(n)的解法，使用到了计数排序。
 *
 * 别人的思路：
 * 借用计数排序的思维，先统计出heights数组每个元素理论上的位置，再通过一次遍历得出与理论值不同的元素的数量即为结果。
 */