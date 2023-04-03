package com.aiz.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PoolTest
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 13:19 2023/2/27
 * @Version 1.0
 */
public class PoolTest {

    public static void main_1(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("test-ThreadPoolExecutor");
                return thread;
            }
        },
                new MyRejectedExecution()
        );

        //2. 让线程池处理任务,没返回结果
        threadPool.execute(() -> {
            System.out.println("没有返回结果的任务");
        });
        //3. 让线程池处理有返回结果的任务
        Future<Object> future = threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("我有返回结果!");
                return "返回结果";
            }
        });
        Object result = future.get();
        System.out.println(result);
        //4. 如果是局部变量的线程池，记得用完要shutdown
        threadPool.shutdown();
    }

    private static class MyRejectedExecution implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("根据自己的业务情况，决定编写的代码!");
        }
    }


    public static void main(String[] args) {
        // 1. 构建定时任务线程池
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(
                5,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        return t;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy()
        );
        // 2. 应用ScheduledThreadPoolExecutor
        // 跟直接执行线程池的execute没啥区别
        pool.execute(() -> {
            System.out.println("execute");
        });

        // 指定延迟时间执行
        System.out.println(System.currentTimeMillis());
        pool.schedule(() -> {
            System.out.println("schedule");
            System.out.println(System.currentTimeMillis());
        }, 2, TimeUnit.SECONDS);

        // 指定第一次的延迟时间，并且确认后期的周期执行时间，周期时间是在任务开始时就计算
        // 周期性执行就是将执行完毕的任务再次社会好延迟时间，并且重新扔到阻塞队列
        // 计算的周期执行，也是在原有的时间上做累加，不关注任务的执行时长。
        System.out.println(System.currentTimeMillis());
        pool.scheduleAtFixedRate(() -> {
            System.out.println("scheduleAtFixedRate");
            System.out.println(System.currentTimeMillis());
        }, 2, 3, TimeUnit.SECONDS);


        // 指定第一次的延迟时间，并且确认后期的周期执行时间，周期时间是在任务结束后再计算下次的延迟时间
        System.out.println(System.currentTimeMillis());
        pool.scheduleWithFixedDelay(() -> {
            System.out.println("scheduleWithFixedDelay");
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 3, TimeUnit.SECONDS);

    }
}
