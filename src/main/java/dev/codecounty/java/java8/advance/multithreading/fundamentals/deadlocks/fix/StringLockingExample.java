package dev.codecounty.java.java8.advance.multithreading.fundamentals.deadlocks.fix;

import java.util.concurrent.locks.ReentrantLock;

public class StringLockingExample {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    private String resource1 = "Initial value of resource1";
    private String resource2 = "Initial value of resource2";

    public void modifyResource1() {
        lock1.lock();
        try {
            // Modify resource1 here
            resource1 = "Modified value of resource1";
        } finally {
            lock1.unlock();
        }
    }

    public void modifyResource2() {
        lock2.lock();
        try {
            // Modify resource2 here
            resource2 = "Modified value of resource2";
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        StringLockingExample stringLockingExample = new StringLockingExample();
        stringLockingExample.modifyResource1();
        stringLockingExample.modifyResource2();
    }
}