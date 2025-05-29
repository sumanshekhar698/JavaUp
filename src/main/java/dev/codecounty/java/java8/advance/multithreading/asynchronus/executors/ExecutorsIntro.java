package dev.codecounty.java.java8.advance.multithreading.asynchronus.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsIntro {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService executorServiceWithSingleThreadUsingFactoryMethod = Executors.newSingleThreadExecutor();
        ExecutorService executorServiceWithSingleThread = Executors.newFixedThreadPool(1);

//        First, an ExecutorService is created using the Executors newFixedThreadPool() factory method.
//        This creates a thread pool with 10 threads executing tasks.
        executorService.execute(() -> System.out.println("Asynchronous task 1:: " + Thread.currentThread()));
        executorService.execute(() -> System.out.println("Asynchronous task 2:: " + Thread.currentThread()));
        executorService.execute(() -> System.out.println("Asynchronous task 3:: " + Thread.currentThread()));
        executorService.shutdown();
    }
}
