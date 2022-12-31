package com.sumanshekhar.java.advance.multithreading.multithreading_0;

public class PrintFirst100NumbersSequentiallyViaMultiThreading {

    public static void main(String[] args) {


        for (int i = 0; i <= 100; i++) {
            new Thread(new PrintNumber(i)).start();
        }
    }
}


class PrintNumber implements Runnable {

    int num;

    public PrintNumber(int numberToPrint) {
        this.num = numberToPrint;
    }

    void seen() {

    }

    @Override
    public void run() {

        System.out.println(num + " ~~> " + Thread.currentThread());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}