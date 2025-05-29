package dev.codecounty.java.java8.advance.multithreading.fundamentals.deadlocks;
/*1. Class and Resources:

The code defines a class named TestDeadlockExample1 with a main method.
It creates two shared resources: resource1 and resource2, represented as String objects.
2. Threads and Locking:

Thread 1:
Locks resource1 first.
Sleeps for 100 milliseconds (simulates some work).
Attempts to lock resource2.
Thread 2:
Locks resource2 first.
Sleeps for 100 milliseconds.
Attempts to lock resource1.
Deadlock Scenario:

If both threads start simultaneously, they can reach a point where:
Thread 1 holds resource1 and waits for resource2.
Thread 2 holds resource2 and waits for resource1.
Neither thread can proceed because they're waiting for each other to release the resource they need. This is a deadlock.
Synchronization and Deadlock:

The synchronized keyword ensures exclusive access to shared resources, preventing multiple threads from modifying them simultaneously.
However, improper use of synchronized blocks can lead to deadlocks when threads acquire locks in a circular dependency.
Key Points:

The code intentionally creates a deadlock to demonstrate the concept.
Deadlocks can occur in real-world applications when multiple threads compete for shared resources.
Careful design and synchronization strategies are crucial to prevent deadlocks in multithreaded programming.
Prevention Strategies:

Avoid nested locks: Ensure threads acquire locks in a consistent order.
Use timeouts: Set a limit on how long threads wait for resources to avoid indefinite waiting.
Employ lock hierarchies: Organize locks in a hierarchy to prevent circular dependencies*/
public class DeadLocksExample {
    public static void main(String[] args) {
        final String resource1 = "res1";
        final String resource2 = "res2";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };


        t1.start();
        t2.start();
    }
}