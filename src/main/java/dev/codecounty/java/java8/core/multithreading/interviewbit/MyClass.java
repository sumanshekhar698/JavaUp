package dev.codecounty.java.java8.core.multithreading.interviewbit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Submit a task to the pool of threads.
        Future<String> future = executorService.submit(() -> {
            // Perform a database query.
            String result = "SELECT * FROM users";

            // Return the result of the database query.
            return result;
        });
        // Submit a task to the pool of threads.
        Future<String> future2 = executorService.submit(() -> {
            // Perform a task.
            return "Task 2 complete.";
        });


        // Get the result of the database query.
        String result = future.get();
        System.out.println(result);
        System.out.println(future2.get());

        // Shutdown the pool of threads.
        executorService.shutdown();
    }
}