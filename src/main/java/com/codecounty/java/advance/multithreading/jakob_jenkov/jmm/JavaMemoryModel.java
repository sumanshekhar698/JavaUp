package com.codecounty.java.advance.multithreading.jakob_jenkov.jmm;

public class JavaMemoryModel {
    public static void main(String[] args) {
        // Each thread has its own rivate thread stack but the Heap is shared

        int myLocalVar = 0;
        String myLocalString = "Text";
        // All the above two vriables belong to the resecitive Thread Stack /
        // stack/method frame
        // In this case its main thread and main stack frame

    }
}

class MyRunnable implements Runnable {

    int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1_00_000; i++) {
            ++count;
        }

        System.out.println(Thread.currentThread() + " : " + this.count);
    }

}
