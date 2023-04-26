package com.aiz.jdk8.method_ref;

import java.time.LocalDate;

/**
 * @author ZhangYao
 * @version 1.0
 * @className Person
 * @description Person
 * @date Create in 15:38 2023/4/26
 */
public class Person {
    String name;
    LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return this.name;
    }
}