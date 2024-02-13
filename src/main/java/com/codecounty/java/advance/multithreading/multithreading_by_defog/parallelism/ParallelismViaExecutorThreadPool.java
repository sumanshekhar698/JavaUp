package com.sumanshekhar.java.advance.multithreading.multithreading_by_defog.parallelism;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelismViaExecutorThreadPool {

    public static void main(String[] args) {
        User u1 = new User(1, 800500);
        User u2 = new User(2, 1200500);

        ExecutorService tPool = Executors.newFixedThreadPool(4);
        tPool.submit(() ->
                processSalary(u1));

        tPool.submit(() ->
                processSalary(u2));

//        task 3
        repoRateForFiscalYear();

//        All the  above task are independent, so it will be a kind of parallelism

    }

    static void processSalary(User u) {
        if (u.salary < 500000)
            System.out.println("No tax aplicable for " + u);
        else if (u.salary >= 500000 && u.salary < 1000000) {
            System.out.println("Tax amount for " + u + "=> " + u.salary * 0.05);
        } else
            System.out.println("Tax amount for " + u + "=> " + u.salary * 0.1);
    }

    static void repoRateForFiscalYear() {
        System.out.println("REPO RATE ==> " + 5.4);
    }
}
