package com.aiz.thread_pool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 10:45 2023/2/27
 * @Version 1.0
 */
public class Test {
    public static void main_1(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(() -> {
            System.out.println("1号任务:" + Thread.currentThread().getName() + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("2号任务:" + Thread.currentThread().getName() + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("3号任务:" + Thread.currentThread().getName() + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main_2(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "111");
        });
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "222");
        });
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "333");
        });
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "," + "444");
        });
    }

    public static void main_3(String[] args) throws IOException, InterruptedException {
        newThreadPool_3();
        System.gc();
        Thread.sleep(5000);
        System.out.println("线程池被回收了！");
        System.in.read();
    }

    private static void newThreadPool_3() {
        ExecutorService threadPool = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 200; i++) {
            final int a = i;
            threadPool.execute(() -> {
                System.out.println(a);
            });
        }
        threadPool.shutdown();
    }

    static ExecutorService threadPool = Executors.newFixedThreadPool(200);

    public static void main_4(String[] args) throws InterruptedException, IOException {
        newThreadPool();
        System.gc();
        Thread.sleep(5000);
        System.out.println("线程池被回收了!!");
        System.in.read();
    }

    private static void newThreadPool() {
        for (int i = 0; i < 200; i++) {
            final int a = i;
            threadPool.execute(() -> {
                System.out.println(a);
            });
        }
        threadPool.shutdown();
        for (int i = 0; i < 200; i++) {
            final int a = i;
            threadPool.execute(() -> {
                System.out.println(a);
            });
        }
    }

    public static void main_5(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 200; i++) {
            final int j = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + j);
            });
        }
    }

    public static void main_6(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
        // 正常执行
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "：1");
        });

        // 延迟执行，执行当前任务延迟5s后再执行
        pool.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + "：2");
        }, 5, TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟5s执行，然后每3s执行一次
        // 这个方法在计算下次执行时间时，是从任务刚刚开始时就计算。
        pool.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ":3");
        }, 2, 1, TimeUnit.SECONDS);

        // 周期执行，当前任务第一次延迟5s执行，然后每3s执行一次
        // 这个方法在计算下次执行时间时，会等待任务结束后，再计算时间
        pool.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + ":4");
        }, 2, 1, TimeUnit.SECONDS);
    }

    /**
     * 非常大的数组
     */
    static int[] nums = new int[1_000_000_000];

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) ((Math.random()) * 1000);
        }
    }

    public static void main_7(String[] args) {
        // ===================单线程累加10亿数据================================
        System.out.println("单线程计算数组总和!");
        long start = System.nanoTime();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long end = System.nanoTime();
        System.out.println("单线程运算结果为:" + sum + "，计算时间为:" + (end - start));
        // 单线程运算结果为:1292852629，计算时间为:448611329
    }


    public static void main(String[] args) {
        // ===================单线程累加10亿数据================================
        System.out.println("单线程计算数组总和!");
        long start = System.nanoTime();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long end = System.nanoTime();
        System.out.println("单线程运算结果为:" + sum + "，计算时间为:" + (end - start));
        // 单线程运算结果为:1290178136，计算时间为:445103473
        // ===================多线程分而治之累加10亿数据================================
        // 在使用forkJoinPool时，不推荐使用Runnable和Callable
        // 可以使用提供的另外两种任务的描述方式
        // Runnable(没有返回结果) -> RecursiveAction
        // Callable(有返回结果) -> RecursiveTask
        ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();
        System.out.println("分而治之计算数组总和!");
        long forkJoinStart = System.nanoTime();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new SumRecursiveTask(0, nums.length - 1));
        Integer result = task.join();
        long forkJoinEnd = System.nanoTime();
        System.out.println("分而治之运算结果为:" + result + "，计算时间为:" + (forkJoinEnd - forkJoinStart));
        // 分而治之运算结果为:1290178136，计算时间为:174586594
    }

    private static class SumRecursiveTask extends RecursiveTask<Integer> {
        /**
         * 指定一个线程处理哪个位置的数据
         */
        private int start, end;
        private final int MAX_STRIDE = 100_000_000;

        // 200_000_000: 147964900
        // 100_000_000: 145942100
        public SumRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            // 在这个方法中，需要设置好任务拆分的逻辑以及聚合的逻辑
            int sum = 0;
            int stride = end - start;
            if (stride <= MAX_STRIDE) {
                // 可以处理任务
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
            } else {
                // 将任务拆分，分而治之。
                int middle = (start + end) / 2;
                // 声明为2个任务
                SumRecursiveTask left = new SumRecursiveTask(start, middle);
                SumRecursiveTask right = new SumRecursiveTask(middle + 1, end);
                // 分别执行两个任务
                left.fork();
                right.fork();
                // 等待结果，并且获取sum
                sum = left.join() + right.join();
            }
            return sum;
        }
    }

}

