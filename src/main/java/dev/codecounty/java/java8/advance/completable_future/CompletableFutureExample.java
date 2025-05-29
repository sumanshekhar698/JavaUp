package dev.codecounty.java.java8.advance.completable_future;

import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


    }


    static void futureTaskExample() throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        int number = 9;

        Future<Long> futureTask = threadpool.submit(() -> findFactorial(number));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        long result = futureTask.get();
        System.out.println(result);

        try {
            // Wait for a reasonable time for tasks to finish
            if (!threadpool.awaitTermination(60, TimeUnit.SECONDS)) {//Assumint in 60 seconds my file processing will be done
                // If some tasks are still running, attempt a forceful shutdown
                List<Runnable> dropedTask = threadpool.shutdownNow();// Interrupts running tasks

// Wait for tasks to respond to interruption
                if (!threadpool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            // Handle interruption during shutdown
            threadpool.shutdownNow();
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
    }

    static void completableFutureExample() throws ExecutionException, InterruptedException {
        int number = 9;

        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> CompletableFutureExample.findFactorial(number));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        long result = completableFuture.get();
        System.out.println(result);
    }

    static long findFactorial(int num) {
        int i;
        long fact = 1;
        int number = 5;//It is the number to calculate factorial
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }


}

