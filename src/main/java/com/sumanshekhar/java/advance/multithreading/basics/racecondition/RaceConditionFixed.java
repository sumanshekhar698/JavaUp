package com.sumanshekhar.java.advance.multithreading.basics.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionFixed {


    AtomicInteger counterAtomic = new AtomicInteger(0);

    static int counter = 0;

    public void incrementCounterAtomic() {
        counterAtomic.incrementAndGet(); // Atomically increments the value
    }

    public static synchronized void incrementCounter() {
        counter++; // Now thread-safe
    }

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(() -> incrementCounter());
        Thread thread2 = new Thread(() -> incrementCounter());

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final counter value
        System.out.println("Counter value: " + counter);
    }
}
