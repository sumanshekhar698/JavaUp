package dev.codecounty.java.java8.advance.multithreading.multithreading_2;

public class VolatileKeywordExample {
//    private static  boolean sayHello = false;
    private static volatile boolean sayHello = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
           while(!sayHello) {
           }

           System.out.println("Hello World!");

           while(sayHello) {
           }

           System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Say Hello..");
        sayHello = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        sayHello = false;
    }
}