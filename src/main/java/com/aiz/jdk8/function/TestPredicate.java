package com.aiz.jdk8.function;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestPredicate
 * @description TestPredicate
 * @date Create in 15:18 2023/4/26
 */
public class TestPredicate {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;
        // true
        predicate.test("foo");
        // false
        predicate.negate().test("foo");
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
