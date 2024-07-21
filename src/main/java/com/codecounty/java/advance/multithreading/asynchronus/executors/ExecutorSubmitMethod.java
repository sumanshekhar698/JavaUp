package com.codecounty.java.advance.multithreading.asynchronus.executors;

import java.util.concurrent.*;
public class ExecutorSubmitMethod {

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

        ExecutorService executorServiceFixedThreadPool = Executors.newFixedThreadPool(10);


        Future submittedFuture = executorService.submit(newRunnable(1000));//submit() returns a Future object that tells the status of the task submitted

        System.out.println(submittedFuture.isDone());

        try {
            Object taskOutput = submittedFuture.get();//makes the parent thread (main) wait/blocked until the task is completed
            System.out.println(taskOutput);// this will be null as the task is runnable and its return type is void
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
