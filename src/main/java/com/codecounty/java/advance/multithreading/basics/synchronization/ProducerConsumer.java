package com.sumanshekhar.java.advance.multithreading.basics.synchronization;

public class ProducerConsumer {
    private static final Object lock = new Object();
    private static Buffer buffer = new Buffer(10); // Buffer size

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Buffer {
        private int[] data;
        private int head;
        private int tail;

        public Buffer(int size) {
            data = new int[size];
            head = 0;
            tail = 0;
        }

        public synchronized void produce(int item) throws InterruptedException {
            while (isFull()) {
                synchronized (lock) {
                    System.out.println("Producer waiting...");
                    lock.wait();
                }
            }

            data[tail] = item;
            tail = (tail + 1) % data.length;

            synchronized (lock) {
                lock.notify(); // Notify the consumer thread
            }

            System.out.println("Produced: " + item);
        }

        public synchronized int consume() throws InterruptedException {
            while (isEmpty()) {
                synchronized (lock) {
                    System.out.println("Consumer waiting...");
                    lock.wait();
                }
            }

            int item = data[head];
            head = (head + 1) % data.length;

            synchronized (lock) {
                lock.notifyAll(); // Notify all waiting producer threads
            }

            System.out.println("Consumed: " + item);

            return item;
        }

        private boolean isFull() {
            return (tail + 1) % data.length == head;
        }

        private boolean isEmpty() {
            return tail == head;
        }
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                try {
                    buffer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}


