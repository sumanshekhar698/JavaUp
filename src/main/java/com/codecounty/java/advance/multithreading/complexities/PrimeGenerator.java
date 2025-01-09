package com.codecounty.java.advance.multithreading.complexities;

import java.math.BigInteger;
import java.util.Random;

public class PrimeGenerator implements Runnable {

    private PrimeStore primeStore;


    public PrimeStore getPrimeStore() {
        return primeStore;
    }

    public PrimeGenerator(PrimeStore primeStore) {
        this.primeStore = primeStore;
    }

    @Override
    public void run() {
        BigInteger bigInteger = new BigInteger(4000, new Random());
//        primeStore.getPrimes().add(bigInteger.nextProbablePrime());
        primeStore.addPrime(bigInteger.nextProbablePrime());//Making Thread Safe :)
    }
}
