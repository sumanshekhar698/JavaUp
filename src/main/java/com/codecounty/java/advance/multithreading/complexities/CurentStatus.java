package com.codecounty.java.advance.multithreading.complexities;

import lombok.SneakyThrows;

public class CurentStatus implements Runnable {

    private PrimeStore primeStore;

    public CurentStatus(PrimeStore primeStore) {
        this.primeStore = primeStore;
    }

    @SneakyThrows
    @Override
    public void run() {
//        while (primeStore.getPrimes().size() < 100) {
        while (primeStore.getSize() < 100) {//Making Thread Safe :)
//            System.out.println("Got " + primeStore.getPrimes().size() + " primes ...");
            System.out.println("Got " + primeStore.getSize() + " primes ...");//Making Thread Safe :)
//            primeStore.getPrimes().forEach(p -> System.out.println(p));
            primeStore.print();//Making Thread Safe :)
            Thread.sleep(1000);
        }

    }
}
