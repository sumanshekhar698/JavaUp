package dev.codecounty.java.java8.advance.multithreading.complexities;

import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

public class PrimeStore {

    private SortedSet<BigInteger> primes;

    public PrimeStore() {
        this.primes = new TreeSet<>();
    }

    // Creating n to handle syncronization
    public int getSize() {
        synchronized (this) {
            return primes.size();
        }
    }

    public void addPrime(BigInteger prime) {
        synchronized (this) {
            primes.add(prime);
        }
    }

    public void print() {
        synchronized (this) {
            primes.forEach(System.out::println);
        }
    }

//    public SortedSet<BigInteger> getPrimes() {//Can throw java.util.ConcurrentModificationException
////        Since we are sharing this in Two Threads, Current Status Thread and the PrimeGenerator work's Thread
//        return primes;
//    }
}
