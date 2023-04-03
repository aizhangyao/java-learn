package com.aiz.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {
    /**
     * 任务的名称
     */
    private String name;

    /**
     * 什么时间点执行
     */
    private Long time;

    public Long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    /**
     * 单位毫秒。
     */
    public Task(String name, Long delay) {
        // 任务名称
        this.name = name;
        this.time = System.currentTimeMillis() + delay;
    }

    /**
     * 设置任务什么时候可以出延迟队列
     *
     * @param unit 单位
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        // 单位是毫秒
        return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 两个任务在插入到延迟队列时的比较方式
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.time - ((Task) o).getTime());
    }


    public static void main(String[] args) throws InterruptedException {
        // 声明元素
        Task task1 = new Task("A", 1000L);
        Task task2 = new Task("B", 5000L);
        Task task3 = new Task("C", 3000L);
        Task task4 = new Task("D", 2000L);
        // 声明阻塞队列
        DelayQueue<Task> queue = new DelayQueue<>();
        // 将元素添加到延迟队列中
        queue.put(task1);
        queue.put(task2);
        queue.put(task3);
        queue.put(task4);
        // 获取元素
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        // A,D,C,B
    }
}