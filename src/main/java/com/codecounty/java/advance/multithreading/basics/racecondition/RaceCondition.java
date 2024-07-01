package com.codecounty.java.advance.multithreading.basics.racecondition;

/*
A race condition in Java occurs when two or more threads try to access and modify the same shared data concurrently, and the outcome of the program depends on the exact timing or order of their execution. Imagine two runners in a race, constantly checking and updating a shared stopwatch. The final time recorded depends on who reaches the stopwatch last, making the outcome unpredictable and unreliable.

Here's a breakdown of a race condition in Java:

1. Shared data: Two or more threads must be accessing the same piece of data, like a counter variable or a linked list.

2. Concurrency: The threads must be able to access the data at the same time. This is common in multithreaded programs where multiple tasks run simultaneously.

3. Modification: At least one of the threads must be trying to modify the shared data. Reading and writing to the same variable without proper synchronization can lead to race conditions.

4. Unpredictable outcome: The final state of the shared data depends on which thread accesses it last. This can lead to incorrect calculations, data corruption, or unexpected program behavior.

Here's an example of a race condition in Java:*/
public class RaceCondition {

    int counter = 0;


    public void incrementCounter() {
        counter++; // Read current value, increment, then write back
    }

    public static void main(String[] args) {

        RaceCondition raceCondition = new RaceCondition();
        // Create two threads
        Thread thread1 = new Thread(() -> raceCondition.incrementCounter());
        Thread thread2 = new Thread(() -> raceCondition.incrementCounter());

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
        System.out.println("Counter value: " + raceCondition.counter);
    }
}
