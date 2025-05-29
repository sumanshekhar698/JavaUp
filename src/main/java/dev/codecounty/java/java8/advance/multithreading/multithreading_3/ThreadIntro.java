package dev.codecounty.java.java8.advance.multithreading.multithreading_3;

class MyThread extends Thread {
//	Thread is  a  kind of worker which will do the task, It represents both work and the worker
//	class Thread implements Runnable 
// We use Thread class when the class is not extending any other class 
//	and we also need to override some other Thread class methods
	public MyThread() {
	}

	public MyThread(Runnable runnable) {
		super(runnable);
	}

	@Override
	public void run() {// Work
		for (int i = 0; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}

class MyTask implements Runnable {
//	Runnable represents a work/task
//	We use the Runnable as preferred and not extends Thread when a class is already extending some other class [Fix for Diamond problem]
	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}

public class ThreadIntro {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());// Prints the current thread in execution

//		Using Thread class
		MyThread thread1 = new MyThread();
		thread1.setName("thread-1[Thread]");

		MyThread thread2 = new MyThread();
		thread2.setName("thread-2[Thread]");
		thread1.start();
		thread2.start();

//		Using Runnable interface
		MyTask task = new MyTask();
		Thread thread3 = new Thread(task);
		thread3.setName("thread-3 [Runnable]");
		thread3.start();

//		Thread thread4 = new MyThread(() -> {
		Thread thread4 = new Thread(() -> {
			for (int i = 0; i < 6; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		});
		thread4.setName("thread-4 [Runnable λ]");
		thread4.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
		System.out.println("Done");
	}
}
