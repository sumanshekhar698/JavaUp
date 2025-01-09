package com.codecounty.java.jdk19.advance.multithreading;

import java.util.ArrayList;

public class OneLacsVirtualThread {

    public static void main(String[] args) {
        System.out.println("START");
        ArrayList<Thread> vThreads = new ArrayList<>();

        int vThreadCount = 100_000;


        for (int i = 0; i < vThreadCount; i++) {
            int vThreadIndex = i;

            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for (int j = 0; j <= 10; j++) {
                    result *= j + 1;
                }
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " Index: " + vThreadIndex + " Result: " + result);
            });

            vThreads.add(vThread);
        }

        vThreads.forEach(vThread -> {
            try {
                vThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("END");
    }
}
