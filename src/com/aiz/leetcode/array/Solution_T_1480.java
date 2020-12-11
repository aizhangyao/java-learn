package com.aiz.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @ClassName Solution_T_1480
 * @Description https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @Author Administrator
 * @Date Create in 20:03 2020/11/18 0018
 * @Version 1.0
 */
public class Solution_T_1480 {

    /**
     * 我自己写的
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int sum = 0;
        while(i!=nums.length){
            sum+=nums[i];
            result[i] = sum;
            i++;
        }
        return result;
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1,2,3,4};
        int[] results = new int[]{1,3,6,10};
        assertArrayEquals(runningSum(nums),results);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{1,1,1,1,1};
        int[] results = new int[]{1,2,3,4,5};
        assertArrayEquals(runningSum(nums),results);
    }

    @Test
    public void test3(){
        int[] nums = new int[]{3,1,2,10,1};
        int[] results = new int[]{3,4,6,16,17};
        assertArrayEquals(runningSum(nums),results);
    }

}
/**
 * 个人即时感悟--2020/11/18
 * 这到题目算是力扣上最简单的题目之一
 * 简单来说就是迭代的思想
 * 看了力扣上一些人在原数组上操作，个人不喜欢在原数组上进行操作。所以空间复杂度多了一点。
 */