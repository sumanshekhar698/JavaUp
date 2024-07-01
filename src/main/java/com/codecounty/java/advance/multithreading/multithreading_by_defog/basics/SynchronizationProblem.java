package com.codecounty.java.advance.multithreading.multithreading_by_defog.basics;

class SynchronizationProblem {

    private static int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter++;
            }
        });

        thread1.start();
        thread2.start();
    }
}