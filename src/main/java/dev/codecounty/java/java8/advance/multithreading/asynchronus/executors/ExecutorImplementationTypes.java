package dev.codecounty.java.java8.advance.multithreading.asynchronus.executors;

import java.util.concurrent.*;

/*Since ExecutorService is an interface, you need to its implementations to make any use of it.
The ExecutorService has the following implementation in the java.util.concurrent package:
- ThreadPoolExecutor
- ScheduledThreadPoolExecutor
*/
public class ExecutorImplementationTypes {

    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 20;
        int keepAliveTime = 6000;
        ExecutorService executorService = new ThreadPoolExecutor(//customized Executor
                corePoolSize,//min no of Threads
                maxPoolSize,// max no of Threads
                keepAliveTime,//max Idle time for a Thread
                TimeUnit.MILLISECONDS,//Time Unit
                new ArrayBlockingQueue<>(128)//this is the queue from where Thread Pool takes task
        );

        ExecutorService executorServiceFixedThreadPool = Executors.newFixedThreadPool(10);


//        First, an ExecutorService is created using the Executors newFixedThreadPool() factory method.
//        This creates a thread pool with 10 threads executing tasks.

        executorService.execute(newRunnable(500));//execute return void, and we cannot know the status of submitted tasks
        executorService.execute(newRunnable(900));
        executorService.execute(newRunnable(1000));
        executorService.execute(newRunnable(2000));
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
