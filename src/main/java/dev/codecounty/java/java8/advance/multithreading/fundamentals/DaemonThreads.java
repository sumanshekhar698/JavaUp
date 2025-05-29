package dev.codecounty.java.java8.advance.multithreading.fundamentals;

public class DaemonThreads {

//    Daemon Threads are non-user threads

    public static void main(String[] args) throws InterruptedException {


        MyThread t1 = new MyThread("t1");
        t1.setDaemon(true);
        t1.start();//JVM does not wait for Daemon thread to STOP

        System.out.println("END");//

    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            for (; ; ) {
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
