package com.codecounty.java.advance.multithreading.multithreading_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public
class

ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable task = new MyTask("Task " + i);
            executor.execute(task);
        }
        executor.shutdown();  // Shutdown the thread pool after all tasks are complete
    }

    static class

    MyTask implements Runnable {
        private String name;
        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Running task: " + name);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Perform the task here
        }
    }
}