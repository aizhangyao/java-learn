package com.aiz.jdk8.method_ref;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZhangYao
 * @version 1.0
 * @className MethodReferenceTest
 * @description MethodReferenceTest
 * @date Create in 15:38 2023/4/26
 */
public class MethodReferenceTest {
    public static void main() {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2023, 9, 1)),
                new Person("001", LocalDate.of(2023, 2, 1)),
                new Person("002", LocalDate.of(2023, 3, 1)),
                new Person("004", LocalDate.of(2023, 12, 1))
        };
        // 使用匿名类
        Arrays.sort(pArr, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        });
        //使用lambda表达式
        Arrays.sort(pArr, (Person a, Person b) -> {
            return a.getBirthday().compareTo(b.getBirthday());
        });
        //使用方法引用，引用的是类的静态方法
        Arrays.sort(pArr, Person::compareByAge);
    }
}