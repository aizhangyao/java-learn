package com.aiz.se.lambda;

/**
 * @ClassName LambdaTester
 * @Description 测试Java8 Lambda表达式
 * @Author ZhangYao
 * @Date Create in 1:12 2020/1/6
 * @Version 1.0
 */
public class LambdaTester {

    /**
     * 自定义接口
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * @param a
     * @param b
     * @param mathOperation
     * @return a和b经过某种数学运算MathOperation后的结果
     */
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        LambdaTester tester = new LambdaTester();
        //类型声明
        MathOperation add = (int a, int b) -> a + b;
        //不声明类型
        MathOperation sub = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation mul = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation div = (int a, int b) -> a / b;

        //输出结果
        System.out.println("10 + 5 = " + tester.operate(10, 5, add));
        System.out.println("10 - 5 = " + tester.operate(10, 5, sub));
        System.out.println("10 * 5 = " + tester.operate(10, 5, mul));
        System.out.println("10 / 5 = " + tester.operate(10, 5, div));

    }

}