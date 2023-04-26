package com.aiz.jdk8.function;

import java.util.function.Supplier;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestSupplier
 * @description TestSupplier
 * @date Create in 15:15 2023/4/26
 */
public class TestSupplier {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person
    }
}
