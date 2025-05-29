package dev.codecounty.java.java8.core.multithreading.interviewbit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksInJava {
    private Lock lock = new ReentrantLock();

    public void doSomething() {
        lock.lock();
        try {
            // ...
        } finally {
            lock.unlock();
        }
    }
}