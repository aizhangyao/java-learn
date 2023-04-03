package com.aiz.leetcode;


import java.util.HashMap;

public class T3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] last = new int[128];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i];

        }

        return result;
    }

    public static void main_2(String[] args) {
        System.out.println(new T3().lengthOfLongestSubstring("aaabcbddc"));
    }

}
