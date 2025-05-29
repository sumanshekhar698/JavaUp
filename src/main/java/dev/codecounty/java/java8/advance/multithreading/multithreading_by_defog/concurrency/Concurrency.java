package dev.codecounty.java.java8.advance.multithreading.multithreading_by_defog.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Concurrency {

    static volatile int ticketsAvailable = 200;
    static volatile AtomicInteger ticketAtomized = new AtomicInteger(200);

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();

        new Thread(() -> {
//            lock.lock();
//            while (ticketsAvailable > 0) {
            while (ticketAtomized.get() > 0) {
//                lock.lock();
                System.out.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketsAvailable--;
                ticketAtomized.decrementAndGet();
//                lock.unlock();
            }
//            if (ticketsAvailable > 0) {
//                System.out.println(ticketsAvailable + " th --> ticket BOOKED");
//                ticketsAvailable--;
//            }
//            lock.unlock();
        }).start();

        new Thread(() -> {
//            lock.lock();
            while (ticketAtomized.get() > 0) {
//                lock.lock();
                System.out.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketsAvailable--;
                ticketAtomized.decrementAndGet();

//                lock.unlock();
            }
//            lock.unlock();
        }).start();

        new Thread(() -> {
//            lock.lock();
            while (ticketAtomized.get() > 0) {
//                lock.lock();
                System.out.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketsAvailable--;
                ticketAtomized.decrementAndGet();

//                lock.unlock();
            }
//            lock.unlock();
        }).start();

        new Thread(() -> {
//            lock.lock();
            while (ticketAtomized.get() > 0) {
//                lock.lock();
                System.out.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketsAvailable--;
                ticketAtomized.decrementAndGet();

//                lock.unlock();
            }
//            lock.unlock();
        }).start();


        Thread.sleep(5000);
    }
}
