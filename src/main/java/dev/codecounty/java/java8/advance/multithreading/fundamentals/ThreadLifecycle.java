package dev.codecounty.java.java8.advance.multithreading.fundamentals;

public class ThreadLifecycle {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());//NEW
        myThread.start();
        System.out.println(myThread.getState());//RUNNABLE

        System.out.println("main Thread state: " + Thread.currentThread().getState());
        System.out.println(myThread.getState());//TIMED_WAITING

        myThread.join();//main() was waiting for myThread to complete its task
        System.out.println(myThread.getState());//TERMINATED


    }

    static class MyThread extends Thread {
        @Override
        public void run() {

            System.out.println("Inside run()");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}


