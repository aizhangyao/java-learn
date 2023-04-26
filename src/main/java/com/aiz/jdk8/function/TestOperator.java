package com.aiz.jdk8.function;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestOperator
 * @description TestOperator
 * @date Create in 15:22 2023/4/26
 */
public class TestOperator {
    public static void main(String[] args) {
        // 输出 递增:3
        UnaryOperator<Integer> increment = x -> x + 1;
        System.out.println("递增:" + increment.apply(2));

        // 输出 相加:5
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println("相加:" + add.apply(2, 3));

        // 输出 最小值:2
        BinaryOperator<Integer> min = BinaryOperator.minBy((o1, o2) -> o1 - o2);
        System.out.println("最小值:" + min.apply(2, 3));
    }
}
