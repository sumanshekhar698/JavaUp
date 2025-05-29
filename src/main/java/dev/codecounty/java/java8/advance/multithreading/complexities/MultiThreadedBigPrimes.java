package dev.codecounty.java.java8.advance.multithreading.complexities;

import java.util.ArrayList;

/*
* We solved Single thread issue by MultiThreading
* Synchronized the WorkFlow
* But still it can have ThreadBlocking as it will print big numbers later on and that can
* blocak some therad:(
*
* - Taking care of Interrupts
* - Share Data Thread Safe
* - And could we have thread blocking
*
*
* We could make this better by using Futures, Synchronized Collection
*
* */
public class MultiThreadedBigPrimes {



    public static void main(String[] args) throws InterruptedException {//In Real World this should be taken care

        long start = System.currentTimeMillis();
        PrimeStore primeStore = new PrimeStore();
        Runnable task = new PrimeGenerator(primeStore);//
        CurentStatus curentStatus = new CurentStatus(primeStore);
        Thread statusThread = new Thread(curentStatus);
        statusThread.start();
//        statusThread.join();//Dangerous Code

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

//        ((PrimeGenerator) task).getPrimeStore().getPrimes().stream().forEach(System.out::println);
        ((PrimeGenerator) task).getPrimeStore().print();
        long end = System.currentTimeMillis();
        System.out.println("Time taken ms : " + (end - start));//10 seconds via MT

    }

}
