package com.codecounty.java.advance.multithreading.basics.deadlocks.fix;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class StringLockingMapExample {
    private final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

    public void lockString(String key) {
        ReentrantLock lock = locks.computeIfAbsent(key, k -> new ReentrantLock());
        lock.lock();
    }

    public void unlockString(String key) {
        ReentrantLock lock = locks.get(key);
        if (lock != null) {
            lock.unlock();
        }
    }

    // Example usage:
    public void modifyResource(String resourceName, String newValue) {
        lockString(resourceName);
        try {
            // Modify the resource associated with resourceName
        } finally {
            unlockString(resourceName);
        }
    }
}