package com.codecounty.java.advance.multithreading.multithreading_0;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {

//        When a java program starts, Usually main thread is one which begins its execution
//        If that's  the case, all the child thread will spawn from the main thread
//        Often it should be the last thread to finish execution

        Thread currentThread = Thread.currentThread();//reference Object of the main thread
        System.out.println(currentThread);

        currentThread.setName("Main Thread");
        System.out.println(currentThread);

//        Thread[main,5,main]   // [Name, priority, group]
//        By default main thread name is "main"
//        By default  thread priority is  5
//        Thread group  is a data structure that controls the state of a collection of thread as whole


        for (int i = 6; i >= 1; i--) {
            Thread.sleep(i * 1000, i * 100);
            System.out.println(i);
        }

    }
}
