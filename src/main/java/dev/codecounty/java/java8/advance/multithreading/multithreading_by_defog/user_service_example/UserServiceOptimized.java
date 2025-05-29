package dev.codecounty.java.java8.advance.multithreading.multithreading_by_defog.user_service_example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserServiceOptimized {

    private static ExecutorService executorServicePool = Executors.newFixedThreadPool(10);
//    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorServicePool.submit(() -> {
                String s = new UserServiceOptimized().birthDate(finalI);
                System.out.println(Thread.currentThread() + s);
            });
        }
        Thread.sleep(1000);
        executorServicePool.shutdown();
    }

    public String birthDate(int userId) {
        final SimpleDateFormat formatter = ThreadSafeFormatter.dateFormatter.get();
        Date date = new Date();
        return userId + " ==> " + formatter.format(date);
    }


}

class ThreadSafeFormatter {
    //        Static declarations in inner classes are not supported at language level '8', it is in JDK 16


    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {

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

    //    with Initial is a factory method for creating thread Local
//    we will pass the Lambda saying this is the initial value I want it for Thread Local
    public static ThreadLocal<SimpleDateFormat> dateFormatter2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));
}
