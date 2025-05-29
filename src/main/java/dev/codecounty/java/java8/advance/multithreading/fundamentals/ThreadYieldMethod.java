package dev.codecounty.java.java8.advance.multithreading.fundamentals;

public class ThreadYieldMethod {

    public static void main(String[] args) {

        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");
        t1.start();
        t2.start();
        t3.start();

    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName());
                Thread.yield();//the current thread is willing to yield its curent processor use
            }
        }
    }
}
