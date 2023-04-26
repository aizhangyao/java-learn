package com.aiz.jdk8.function;

import java.util.Comparator;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestComparator
 * @description TestComparator
 * @date Create in 15:09 2023/4/26
 */
public class TestComparator {
    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        // > 0
        comparator.compare(p1, p2);
        // < 0
        comparator.reversed().compare(p1, p2);
    }
}
