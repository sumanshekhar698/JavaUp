package dev.codecounty.java.java8.advance.multithreading.asynchronus.executors;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ExecutorInvokeAnyMethod {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ArrayList<Callable<Long>> listOfCallables = new ArrayList<>();

        listOfCallables.add(newCallable(493));
        listOfCallables.add(newCallable(495));
        listOfCallables.add(newCallable(494));

        try {
            Long leastTime = executorService.invokeAny(listOfCallables);//invokeAny() returns the result of one of the tasks that completed 1st
            //Rest all will be canceled, Very Useful when querying from multiple servers like CDN, so whichever server is fast
            //and once we get the result, cancel all the other task
            System.out.println(leastTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
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
//                return Thread.currentThread().getId(); //time taken for this
                return (long) time;

            }
        };
    }

}
