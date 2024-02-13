package com.sumanshekhar.java.advance.multithreading.multithreading_2;
class A {
    synchronized void sum(int n)
    {
 
        // Creating a thread instance
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                t.getName() + " : " + (n + i));
        }
    }
}
 
// Class B extending thread class
class B extends Thread {
 
    // Creating an object of class A
    SynchronizationOfThreads a = new SynchronizationOfThreads();
    public void run()
    {
    	A a = new A();
        // Calling sum() method
        a.sum(10);
    }
}
class SynchronizationOfThreads {
    public static void main(String[] args)
    {
 
        // Creating an object of class B
        B b = new B();
 
        // Initializing instance t1 of Thread
        // class with object of class B
        Thread t1 = new Thread(b);
 
        // Initializing instance t2 of Thread
        // class with object of class B
        Thread t2 = new Thread(b);
 
        // Initializing thread t1 with name
        //'Thread A'
        t1.setName("Thread A");
 
        // Initializing thread t2 with name
        //'Thread B'
        t2.setName("Thread B");
 
        // Starting thread instance t1 and t2
        t1.start();
        t2.start();
    }
}