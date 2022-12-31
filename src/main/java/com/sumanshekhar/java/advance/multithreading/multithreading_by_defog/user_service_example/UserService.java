package com.sumanshekhar.java.advance.multithreading.multithreading_by_defog.user_service_example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

    private static ExecutorService executorServicePool = Executors.newFixedThreadPool(10);
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {

/*                new Thread(() -> {
            String s = new UserService().birthDate(2);
            System.out.println(Thread.currentThread() + s);
        }).start();*/


/*        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                String s = new UserService().birthDate(finalI);// TODO final investigation
                System.out.println(Thread.currentThread() + s);
            }).start();
        }*/


//        Submitting 1000 task of 1000 user id to pool of 10 thread
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorServicePool.submit(() -> {
                String s = new UserService().birthDate(finalI);
                System.out.println(Thread.currentThread() + s);
            });
        }

        Thread.sleep(1000);
        executorServicePool.shutdown();
    }

    public String birthDate(int userId) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
//        System.out.println(formatter.format(date));
        return userId + " ==> " + formatter.format(date);
    }
}
