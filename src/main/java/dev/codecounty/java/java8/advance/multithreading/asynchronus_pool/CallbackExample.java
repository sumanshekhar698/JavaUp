package dev.codecounty.java.java8.advance.multithreading.asynchronus_pool;

import java.util.concurrent.*;

public class CallbackExample {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Define a callable task that simulates some work
        Callable<String> task = () -> {
            Thread.sleep(4000); // Simulate some work
            return "Task completed!";
        };

        // Submit the task to the executor and get a Future object
        Future<String> future = executor.submit(task);

//        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture(future.get());
        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture(future.get());
        completableFuture.thenAccept(result -> System.out.println("Result: " + result));
        // Define a callback function to be executed when the task finishes
//        future.thenAccept(result -> System.out.println("Result: " + result));

        // Do other work while the task is running asynchronously
        System.out.println("Doing other work...");

        // Shutdown the executor (optional)
        executor.shutdown();
    }
}
