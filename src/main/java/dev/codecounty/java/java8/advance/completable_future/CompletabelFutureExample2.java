package dev.codecounty.java.java8.advance.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletabelFutureExample2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // Create a thread pool

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate an asynchronous task that takes 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result";
        }, executor); // Explicitly use the executor

        System.out.println("Doing something else...");

        // Keep the main thread alive until the future completes
        future.join();


        // Handle the future result
        future.thenAccept(result -> System.out.println("Result: " + result));

        executor.shutdown(); // Shutdown the thread pool after use
    }

    void badExample() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate an asynchronous task that takes 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result";
        });

// Do some other work while the asynchronous task is running
        System.out.println("Doing something else...");


// Handle the future result (potentially after the main task has finished)
        future.thenAccept(result -> System.out.println("Result: " + result));
    }
}
