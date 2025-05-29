package dev.codecounty.java.java8.advance.multithreading.fundamentals;

public class ThreadInterrupts {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();
        t1.interrupt();//Exception because of interrupts as t1 was sleeping

        System.out.println("END");

    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("waiting over for  run()");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


