package com.codecounty.java.advance.multithreading.asynchronus.executors;

import com.codecounty.java.core.oops.inheritace.rules.C;

import java.util.concurrent.*;

public class ExecutorSubmitMethodWithCallable {

    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 20;
        int keepAliveTime = 6000;
        ExecutorService executorService = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(128)//this is the queue from where Thread Pool takes a task
        );

        Future submittedFuture = executorService.submit(newCallable(1000));//submit() returns a Future object that tells the status of the task submitted

        System.out.println(submittedFuture.isDone());

        try {
            Long deltaTime = (Long) submittedFuture.get();//makes the parent thread (main) wait/blocked until the task is completed
            System.out.println(deltaTime);// this will be a Long as its return type of call()
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(submittedFuture.isDone());
        System.out.println("Before Shutdown");
        executorService.shutdown();
        System.out.println("End of main()");
    }


    private static Callable<Long> newCallable(int time) {
        return new Callable() {

            @Override
            public Long call() {
                long start = System.nanoTime();

                for (int i = 0; i < 5; i++) {
                    System.out.println("Asynchronous task :: " + Thread.currentThread());
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                long end = System.nanoTime();
                return end - start; //time taken for this

            }
        };
    }

    private static Runnable newRunnable(int time) {
        return new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Asynchronous task :: " + Thread.currentThread());
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }
}
