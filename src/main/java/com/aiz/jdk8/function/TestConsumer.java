package com.aiz.jdk8.function;

import java.util.function.Consumer;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestConsumer
 * @description TestConsumer
 * @date Create in 15:13 2023/4/26
 */
public class TestConsumer {
    public static void main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
