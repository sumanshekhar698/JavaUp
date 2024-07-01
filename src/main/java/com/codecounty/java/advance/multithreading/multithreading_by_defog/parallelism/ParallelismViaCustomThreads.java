package com.codecounty.java.advance.multithreading.multithreading_by_defog.parallelism;

public class ParallelismViaCustomThreads {

    public static void main(String[] args) {
        User u1 = new User(1, 800500);
        User u2 = new User(2, 1200500);

//        task 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                processSalary(u1);
            }
        }).start();

//        task 2
        new Thread(() -> {
            processSalary(u2);//using lambda
        }).start();

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
