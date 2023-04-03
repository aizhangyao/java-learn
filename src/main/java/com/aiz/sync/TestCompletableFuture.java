package com.aiz.sync;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCompletableFuture {
    public static void main_1(String[] args) {
        // 生产者，可以指定返回结果
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务开始执行");
            System.out.println("异步任务执行结束");
            return "返回结果";
        });

        String result1 = firstTask.join();
        String result2 = null;

        try {
            result2 = firstTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(result1 + "," + result2);
    }

    public static void main_2(String[] args) throws IOException {
        CompletableFuture.runAsync(() -> {
            System.out.println("任务go");
            System.out.println("任务done");
        });
        System.in.read();
    }

    public static void main_3(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        /*
        CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
            String id = UUID.randomUUID().toString();
            System.out.println("执行任务A：" + id);
            return id;
        });
        CompletableFuture<String> taskB = taskA.thenApply(result -> {
            System.out.println("任务B获取到任务A结果:" + result);
            result = result.replace("-", "");
            return result;
        });
        System.out.println("main线程拿到结果：" + taskB.join());
        */

        CompletableFuture<String> taskB = CompletableFuture.supplyAsync(() -> {
            String id = UUID.randomUUID().toString();
            System.out.println("执行任务A:" + id + "," + Thread.currentThread().getName());
            return id;
        }).thenApplyAsync(result -> {
            System.out.println("任务B获取到任务A结果:" + result + "," + Thread.currentThread().getName());
            result = result.replace("-", "");
            return result;
        }, executor);
        System.out.println("main线程拿到结果：" + taskB.join());
    }

    public static void main_4(String[] args) throws IOException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("任务A");
            return "abcdefg";
        }).thenAccept(result -> {
            System.out.println("任务b，拿到结果处理：" + result);
        });
        System.in.read();
    }

    public static void main_5(String[] args) throws IOException {
        CompletableFuture.runAsync(() -> {
            System.out.println("任务A!!");
        }).thenRun(() -> {
            System.out.println("任务B!!");
        });
        System.in.read();
    }

    public static void main_6(String[] args) throws IOException {
        CompletableFuture<Integer> taskC = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务A");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 78;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("任务B");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 66;
        }), (resultA, resultB) -> {
            System.out.println("任务C");
            int resultC = resultA + resultB;
            return resultC;
        });

        System.out.println(taskC.join());
        System.in.read();
    }

    public static void main_7(String[] args) throws IOException {
        CompletableFuture<Integer> taskC = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务A");
            return 78;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("任务B");
            return 66;
        }), resultFirst -> {
            System.out.println("任务C");
            return resultFirst;
        });
        System.out.println(taskC.join());
        System.in.read();
    }

    public static void main_8(String[] args) throws IOException {
        CompletableFuture<Integer> taskC = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务A");
            // int i = 1 / 0;
            return 78;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("任务B");
            return 66;
        }), resultFirst -> {
            System.out.println("任务A");
            return resultFirst;
        }).handle((r, ex) -> {
            System.out.println("handle:" + r);
            System.out.println("handle:" + ex);
            return -1;
        });
        /*
        .exceptionally(ex -> {
            System.out.println("exceptionally:" + ex);
            return -1;
        })*/
        /*
        .whenComplete((r, ex) -> {
            System.out.println("whenComplete:" + r);
            System.out.println("whenComplete:" + ex);
        });
         */
        System.out.println(taskC.join());
        System.in.read();
    }

    public static void main_9(String[] args) throws IOException {
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务A");
                }),
                CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务B");
                }),
                CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务C");
                })
        ).thenRun(() -> {
            System.out.println("任务D");
        });

        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        CompletableFuture.anyOf(
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务A");
                    return "A";
                }),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务B");
                    return "B";
                }),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("任务C");
                    return "C";
                })).thenAccept(r -> {
            System.out.println("任务D执行，" + r + "先执行完毕的");
        });
        System.in.read();
    }

}
