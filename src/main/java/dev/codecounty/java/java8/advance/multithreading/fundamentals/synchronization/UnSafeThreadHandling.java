package dev.codecounty.java.java8.advance.multithreading.fundamentals.synchronization;

public class UnSafeThreadHandling {

    static class Counter {
        private int x = 0;

        public int getX() {
            return x;
        }


        void incrementX() {

            ++x;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                counter.incrementX();
            }).start();

        }

        Thread.sleep(10000);
        System.out.println("10000 ? " + counter.getX());

    }

}
