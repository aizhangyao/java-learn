package com.aiz.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ZhangYao
 * @version 1.0
 * @className StreamTest
 * @description StreamTest
 * @date Create in 15:55 2023/4/26
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("ZhangYao", "Is", "Learning", "Java8");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
}
