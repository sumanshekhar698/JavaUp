package com.sumanshekhar.java.advance.multithreading.multithreading_by_defog.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserServiceOptimized {

    private static ExecutorService executorServicePool = Executors.newFixedThreadPool(10);
//    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {


//        Submitting 1000 task of 1000 user id to pool of 10 thread
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorServicePool.submit(() -> {
                String s = new UserServiceOptimized().birthDate(finalI);
                System.out.println(Thread.currentThread() + s);
            });
        }

        Thread.sleep(1000);
    }

    public String birthDate(int userId) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        SimpleDateFormat formatter = ThreadSafeFormatter.dateFormatter.get();
        Date date = new Date();
//        System.out.println(formatter.format(date));
        return userId + " ==> " + formatter.format(date);
    }

    class ThreadSafeFormatter {
        //        Static declarations in inner classes are not supported at language level '8', it is in JDK 16
        public  ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {

            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                return super.initialValue();
            }

            @Override
            public SimpleDateFormat get() {
                return super.get();
            }
        };
    }
}
