package com.leetbook.array;

/**
 * @ClassName T1
 * @Description https://leetcode-cn.com/leetbook/detail/top-interview-questions-easy/
 * @Author ZhangYao
 * @Date Create in 17:12 2021/1/25 0025
 * @Version 1.0
 */
public class T1 {

    public int removeDuplicates(int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(test1());
        //System.out.println(test2());
    }

    public static int test1(){
        int num = 10;
        try{
            System.out.println("try");
        }catch (Exception e){
            System.out.println("error");
        }finally {
            if(num>20){
                System.out.println("num>20:"+num);
            }
            System.out.println("finally");
            num = 100;
        }
        return num;
    }

    public static int test2(){
        Num number = new Num();
        try{
            System.out.println("try");
        }catch (Exception e){
            System.out.println("error");
        }finally {
            if(number.num>20){
                System.out.println("num>20:"+number.num);
            }
            System.out.println("finally");
            number.num = 100;
        }
        return number.num;
    }

    static class Num{
        public int num = 10;
    }


}
