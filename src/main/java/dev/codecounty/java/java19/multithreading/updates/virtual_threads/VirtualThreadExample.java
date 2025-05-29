package dev.codecounty.java.java19.multithreading.updates.virtual_threads;

public class VirtualThreadExample {

    public static void main(String[] args) {

        System.out.println("START");

        Runnable ruunable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " Thread Name: " + Thread.currentThread().getName());
            }
        };

        Thread vThread1 = Thread.ofVirtual().start(ruunable);
        // we use start method to start the thread immediately

        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(ruunable);
        // we use unstarted method to create the thread but not start it immediately



/*
        Java virtual threads are lightweight threads that are managed by the JVM.
        They are also known as Project Loom.
        They are not OS threads, they are user-level threads.
        They are also known as fibers.
        They are faster to create and destroy than OS threads.
        They are also known as green threads
        Java Virtual Threads are instance of Thread class.

        We can create Java Virtual Threads using Thread.ofVirtual() method.
        We can start the thread immediately using start() method
        or we can create the thread but not start it immediately using unstarted() method.
*/

//        vThread1.start();// Exception in thread "main" java.lang.IllegalThreadStateException: Already started
        vThreadUnstarted.start();


        try {
            vThreadUnstarted.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("END");
    }
}
