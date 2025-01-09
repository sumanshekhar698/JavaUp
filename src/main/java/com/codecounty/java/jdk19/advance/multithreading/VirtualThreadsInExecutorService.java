package com.codecounty.java.jdk19.advance.multithreading;

import java.util.concurrent.*;

public class VirtualThreadsInExecutorService {

    public static void main(String[] args)  {
        System.out.println("START");

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        // It uses one virtual thread per task submitted to the executor.

        Future<?> submit = executor.submit(() -> {
            int result = 1;
            for (int j = 0; j <= 10; j++) {
                result *= j + 1;
            }
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " Result: " + result);
        });


        Object o = null;//get method blocks the main thread until the task is completed
        try {
            o = submit.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(o);


        Callable<String> callable = new Callable<>() {


            @Override
            public String call() throws Exception {
                System.out.println("Callable executed by vThread: " + Thread.currentThread().getName());
                return "Result from Callable";
            }
        };

        Future<String> submit1 = executor.submit(callable);
        String s = null;
        try {
            s = submit1.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);

//        Why we use executor to execute virtual threads? and we can start the virtual threads directly using Thread.ofVirtual().start(runnable)
//      -  We can have a system where we are already using executor service to execute the tasks.
//      - The handling of submit, get, and exception handling is already implemented in the executor service.
//        So, we can use the same executor service to execute the virtual threads.
        

        System.out.println("END");
    }
}
