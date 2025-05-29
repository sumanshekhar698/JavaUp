package dev.codecounty.java.java8.advance.multithreading.multithreading_by_defog.basics;

/*the volatile keyword is not foolproof. It can help to prevent visibility problems in some cases, but it is not a guarantee. There are still some situations where the changes made to a volatile variable may not be visible to other threads immediately.

For example, if a volatile variable is stored in a cache, the changes made to the variable in memory may not be reflected in the cache immediately. This is because the cache may not be updated as frequently as memory.

Another issue is that the volatile keyword does not guarantee that the changes made to a variable will be seen by all threads. If a thread is blocked waiting for a lock, it will not see the changes made to a volatile variable until the lock is released.

Overall, the volatile keyword is a useful tool for preventing visibility problems, but it is not a complete solution. If you are writing multithreaded code that relies on the visibility of shared variables, you should carefully consider the potential for visibility problems and take steps to mitigate them.

Here are some additional things to keep in mind about the volatile keyword:

🔹The volatile keyword only guarantees that the changes made to a variable will be visible to other threads immediately if the variable is stored in main memory.
🔹The volatile keyword does not guarantee that the changes made to a variable will be seen by all threads.
🔹The volatile keyword can have a performance impact, so it should only be used when necessary.*/
public class VisiblityProblem {

    private volatile static boolean ready = false;
    private static int number = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            number = 42;
            ready = true;
        });

        Thread thread2 = new Thread(() -> {
            while (!ready) {
                // Do nothing.
                System.out.println("Thread 2");
            }
            System.out.println(number);
        });

        thread1.start();
        thread2.start();
    }
}

/*The output of the code will vary depending on the JVM implementation and the underlying hardware. However, it is possible that the output will show that the number variable has not been printed by the second thread by the time the second thread terminates. This is because the changes made to the ready variable in the first thread may not have been visible to the second thread immediately.*/
/*The output of the code will vary depending on the JVM implementation and the underlying hardware. However, it is possible that the output will show that the number variable has not been printed by the second thread by the time the second thread terminates. This is because the changes made to the ready variable in the first thread may not have been visible to the second thread immediately.*/
