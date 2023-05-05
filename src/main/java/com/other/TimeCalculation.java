package com.other;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TimeCalculation
 * @description 计算时间小tool
 * @date Create in 16:59 2022/12/12
 */
public class TimeCalculation {
    public static void main(String[] args) {
        int minTotal = 0;
        int secondTotal = 0;
        String str = "10:36+15:36+17:26+15:16+18:05+5:55+26:19+4:45+11:14+2:56+3:38+11:07+21:07+22:12+20:15+8:19+7:16+14:45+16:21+13:31+24:35+9:14+20:31+7:44+12:48+10:29+6:29+8:33+3:03+2:19+17:45+5:49+11:49+1:30+9:01+8:19+16:44+6:30+6:04+4:34";
        String[] splits = str.split("\\+");
        for (String split : splits) {
            String[] arr = split.split(":");
            int min = Integer.valueOf(arr[0]);
            int second = Integer.valueOf(arr[1]);
            minTotal += min;
            secondTotal += second;
        }
        System.out.println((minTotal + (secondTotal / 60)) + "min");
    }
}
