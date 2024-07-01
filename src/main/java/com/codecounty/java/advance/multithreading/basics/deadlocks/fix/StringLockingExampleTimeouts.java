package com.codecounty.java.advance.multithreading.basics.deadlocks.fix;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class StringLockingExampleTimeouts {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    private String resource1 = "Initial value of resource1";
    private String resource2 = "Initial value of resource2";

    public void modifyResource1() {
        try {
            if (lock1.tryLock(1000, TimeUnit.MILLISECONDS)) {  // Attempt to acquire lock1 with a timeout
                try {
                    // Modify resource1 here
                    resource1 = "Modified value of resource1";
                } finally {
                    lock1.unlock();
                }
            } else {
                // Handle the case where the lock is not acquired within the timeout
                System.out.println("Failed to acquire lock1 for resource1 within timeout");
            }
        } catch (InterruptedException e) {
            // Handle interruption if needed
        }
    }

    public void modifyResource2() {
        try {
            if (lock2.tryLock(1000, TimeUnit.MILLISECONDS)) {  // Attempt to acquire lock2 with a timeout
                try {
                    // Modify resource2 here
                    resource2 = "Modified value of resource2";
                } finally {
                    lock2.unlock();
                }
            } else {
                // Handle the case where the lock is not acquired within the timeout
                System.out.println("Failed to acquire lock2 for resource2 within timeout");
            }
        } catch (InterruptedException e) {
            // Handle interruption if needed
        }
    }
}