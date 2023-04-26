package com.aiz.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author ZhangYao
 * @version 1.0
 * @className StreamDemo
 * @description StreamDemo
 * @date Create in 16:04 2023/4/26
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<String> stringCollection = Arrays.asList("Love", "is", "the", "most", "difficult", "thing", "in", "the", "world");
        // 1.Filter 过滤
        System.out.println("Filter 过滤");
        stringCollection.stream()
                .filter(s -> s.startsWith("i"))
                .forEach(System.out::println);

        // 2.Sort 排序
        System.out.println("Sort 排序");
        stringCollection.stream()
                .sorted().filter(s -> s.startsWith("i"))
                .forEach(System.out::println);

        // 3.Map 映射
        System.out.println("Map 映射");
        stringCollection.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);

        // 4.Match 匹配
        System.out.println("Match 匹配");
        boolean anyStartsWithI = stringCollection.stream().anyMatch((s) -> s.startsWith("i"));
        // true
        System.out.println(anyStartsWithI);
        boolean allStartsWithI = stringCollection.stream().allMatch((s) -> s.startsWith("i"));
        // false
        System.out.println(allStartsWithI);
        boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
        // true
        System.out.println(noneStartsWithZ);

        // 5.Count 计数
        System.out.println("Count 计数");
        long startsWithW = stringCollection.stream().filter((s) -> s.startsWith("w")).count();
        // 1
        System.out.println(startsWithW);

        // 6.Reduce 归约
        System.out.println("Reduce 归约");
        Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        // Love#difficult#in#is#most#the#the#thing#world
        reduced.ifPresent(System.out::println);
    }
}
