package com.codecounty.java.advance.multithreading.complexities;

import java.math.BigInteger;
import java.util.Random;
import java.util.TreeSet;

public class SingleThreadBigPrimes {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        TreeSet<BigInteger> primes = new TreeSet<>();


        while (primes.size() < 20) {
            BigInteger bigInteger = new BigInteger(4000, new Random());
//        System.out.println(bigInteger);
            primes.add(bigInteger.nextProbablePrime());
        }

        long end = System.currentTimeMillis();
        System.out.println("Delta :ms: " + (end - start));//40 seconds
    }


}
