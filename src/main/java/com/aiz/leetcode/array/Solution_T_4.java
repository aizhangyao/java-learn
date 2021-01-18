package com.aiz.leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName Solution_T_4
 * @Description TODO https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @Author Administrator
 * @Date Create in 15:16 2020/11/18 0018
 * @Version 1.0
 */
public class Solution_T_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len =  nums1.length+nums2.length;
        int[] nums = new int[len];

        for(int i=0,j=0,q=0;i<=len1&&j<=len2&&q<=len;q++){
            if(nums1[i]>=nums2[j]){
                nums2[j] = nums[q];
            }
            //TODO
        }

        return 1;
    }

    @Test
    public void test1(){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        assertEquals(findMedianSortedArrays(nums1,nums2),2);
    }

    @Test
    public void test2(){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        assertEquals(findMedianSortedArrays(nums1,nums2),2.5);
    }

    @Test
    public void test3(){
        int[] nums1 = {0,0};
        int[] nums2 = {0,0};
        assertEquals(findMedianSortedArrays(nums1,nums2),0);
    }

    @Test
    public void test4(){
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(findMedianSortedArrays(nums1,nums2),1);
    }

    @Test
    public void test5(){
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(findMedianSortedArrays(nums1,nums2),2);
    }

}
