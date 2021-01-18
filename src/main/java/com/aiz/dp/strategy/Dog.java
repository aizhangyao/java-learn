package com.aiz.dp.strategy;

/**
 * @ClassName Dog
 * @Description
 * @Author Yao
 * @Date Create in 11:41 下午 2020/12/16
 * @Version 1.0
 */
public class Dog implements Comparable<Dog>{
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog dog) {
        if (this.food < dog.food) return -1;
        else if (this.food > dog.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
