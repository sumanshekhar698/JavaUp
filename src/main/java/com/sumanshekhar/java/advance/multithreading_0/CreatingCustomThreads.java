package com.sumanshekhar.java.advance.multithreading_0;

class CustomThread_1 implements Runnable {

    Thread t;

    public CustomThread_1() {
        //Creating a and assignig the thread object by adding this  object
        t = new Thread(this, "ct_01");
    }

    @Override
    public void run() {
        for (int i = 6; i >= 1; i--) {
            try {
                Thread.sleep(i * 500, i * 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " : " + Thread.currentThread());
        }
    }
}

class CustomThread_2 extends Thread {

    public CustomThread_2() {
        super("ct_02");
    }

    @Override
    public void run() {
        for (int i = 6; i >= 1; i--) {
            try {
                Thread.sleep(i * 500, i * 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " : " + Thread.currentThread());
        }
    }
}

public class CreatingCustomThreads {
    public static void main(String[] args) {

        System.out.println("START");
//        Creating custom threads
//        #1 By using a class which implements Runnable
        CustomThread_1 ct1 = new CustomThread_1();
        ct1.t.start();

//        #1.1 By using  Runnable and lambda
        Thread t1 = new Thread(() -> {
            for (int i = 6; i >= 1; i--) {
                try {
                    Thread.sleep(i * 500, i * 100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i + " : " + Thread.currentThread());
            }
        });
        t1.start();


        System.out.println("END");

    }
}

