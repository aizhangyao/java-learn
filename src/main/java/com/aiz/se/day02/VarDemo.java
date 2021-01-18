package com.aiz.se.day02;

/**
 * @ClassName VarDemo
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 19:07 2019/10/14
 * @Version 1.0
 */
public class VarDemo {
    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        //定义变量
        int i= 19;
        long a = 100L;
        float weight = 67.5F;
        boolean b = true;
        char c = 'A';
        //定义字符串对象变量
        String website = "http://www.aizhangyao.com";
        //打印输出以上变量
        System.out.println("变量i的值:"+i);
        System.out.println("变量a的值:"+a);
        System.out.println("变量weight的值:"+weight);
        System.out.println("变量b的值:"+b);
        System.out.println("变量c的值:"+c);
        System.out.println("变量website的值:"+website);
        //注：任何数据类型与字符串做+运算，其结果都是字符串的拼接。
        System.out.println("--------------------------------");
        i = 200;
        b = false;
        System.out.println("变量i的值:"+i);
        System.out.println("变量b的值:"+b);
    }

}