package com.aiz.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 01:40 2023/2/24
 * @Version 1.0
 */
public class Test {
    public static void main_1(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(4);
    }

    public static void main_2(String[] args) throws InterruptedException {
        // 必须设置队列的长度
        ArrayBlockingQueue queue = new ArrayBlockingQueue(4);
        // 生产者扔数据
        queue.add("1");
        queue.offer("2");
        queue.offer("3", 2, TimeUnit.SECONDS);
        queue.put("2");
        // 消费者取数据
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.take());

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    }


    public static void main_3(String[] args) {
        PriorityBlockingQueue queue = new PriorityBlockingQueue<>();
        queue.add("234");
        queue.add("123");
        queue.add("456");
        queue.add("345");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        /* 输出顺序依次为123、234、345、456 */

        DelayQueue delayQueue = new DelayQueue();

    }


    public static void main_4(String[] args) throws InterruptedException {
        // 因为当前队列不存在数据，没有长度的概念。
        SynchronousQueue queue = new SynchronousQueue();
        String msg = "消息!";
        /*new Thread(() -> {
            // b = false:代表没有消费者来拿
            boolean b = false;
            try {
                b = queue.offer(msg, 1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(b);
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println(queue.poll());
        }).start();*/
        new Thread(() -> {
            try {
                System.out.println(queue.poll(1, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            queue.offer(msg);
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        // 因为当前队列不存在数据，没有长度的概念。
        //SynchronousQueue queue = new SynchronousQueue(true);
        SynchronousQueue queue = new SynchronousQueue(false);
        new Thread(() -> {
            try {
                queue.put("生1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("生2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                queue.put("生3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("消1:" + queue.poll());
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("消2:" + queue.poll());
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("消3:" + queue.poll());
        }).start();
    }
}
