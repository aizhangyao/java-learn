package com.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhangYao
 * @className TestLambda
 * @description Lambda写法
 * @date Create in 00:20 2023/10/13
 */
public class TestLambda {

    @Test
    public void test() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("001", "Jack", 10));
        students.add(new Student("002", "Dawson", 20));
        students.add(new Student("003", "Leo", 30));
        students.add(new Student("004", "Tom", 40));

        System.out.println("print all students:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("print all students end.");

        List<Student> fStudents = students.stream().filter(student -> student.age == 10).collect(Collectors.toList());
        System.out.println("print filter students:");
        for (Student student : fStudents) {
            System.out.println(student);
        }
        System.out.println("print filter students end.");

        List<String> lists = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
        String result = String.join(",", lists);
        System.out.println(result);

        System.out.println(Calendar.getInstance().getTime());
    }

    static class Student {
        private String stuNo;
        private String name;
        private int age;

        public Student(String stuNo, String name, int age) {
            this.stuNo = stuNo;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "stuNo='" + stuNo + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
