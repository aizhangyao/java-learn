package com.aiz.se.day04.hw;

/**
 * @ClassName PerfectNum
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 15:54 2019/10/17
 * @Version 1.0
 */
public class PerfectNum {
    /**
     * 4.找出1000以内的完美数。
     * 完美数是指这个数刚好是它的所有约数之和。
     * 如：
     * 6=1+2+3；
     * @param args
     */
    public static void main(String[] args) {
        //遍历1~1000
        for(int i = 0;i<=1000;i++){
            //判断是否是完美数
            if(isPerfectNum(i)){
                System.out.println(i);
            }
        }

    }

    /**
     * 判断一个数是否是完美数
     * @param num
     * @return
     */
    public static boolean isPerfectNum(int num){
        if(num<=0){
            return false;
        }
        int sum = 0;//计算约数和
        for(int i=1;i<num;i++){
            if(num%i==0){
                sum+=i;
            }
        }
        if(num==sum){
            return true;
        }
        return false;
    }

}