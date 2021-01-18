package com.aiz.se.day03.prac;

/**
 * @ClassName MulTable
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 11:47 2019/10/17
 * @Version 1.0
 */
public class MulTable {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("9*9乘法表：");
        //定义循环次数常量
        final int ROWS = 9;
        //外层循环控制“行数”
        for (int i = 1; i <= ROWS; i++) {
            //内层循环控制“列数”
            for (int j = 1; j <= i; j++) {
                //输出
                System.out.print(j + "*" + i + "=" + i * j + " ");
            }
            //换行【内层循环结束后，再换行】
            System.out.println();
        }
    }

}