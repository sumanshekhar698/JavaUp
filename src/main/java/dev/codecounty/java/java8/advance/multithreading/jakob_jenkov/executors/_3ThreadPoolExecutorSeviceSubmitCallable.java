package dev.codecounty.java.java8.advance.multithreading.jakob_jenkov.executors;

import java.util.List;
import java.util.concurrent.*;

public class _3ThreadPoolExecutorSeviceSubmitCallable {// Used to create customized thread pool
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		// Internally ThreadPool, create a Future and connects it to the corresponding
		// task internally, the future is returned to the Parent therad even before
		// execution
		Future<String> future1 = executorService.submit(newCallable("Hi "));
		Future<String> future2 = executorService.submit(newCallable("Hey "));

		System.out.println(future1.isDone());// probably false
		System.out.println(future2.isDone());// probably false

		try {
			System.out.println(future1.get());// the call() returned value
			System.out.println(future2.get());// the call() returned value

			// Also get method blocks the thread until result is available
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(future1.isDone());// for sure true
		System.out.println(future2.isDone());// for sure true

		executorService.shutdown();// this shutdown() waits for all the threads to be
		// completed

	}

	// private static Callable newCallable(String msg) {

	// return new Callable() {
	// public Object call() {
	// String newMsag = "Message ::" + msg + " " + Thread.currentThread().getName();
	// return newMsag;
	// }
	// };

	// }

	private static Callable<String> newCallable(String msg) {// Type safe version

		return new Callable<String>() {
			public String call() {
				String newMsg = "Message | " + msg + " threadData :: " + Thread.currentThread().getName();
				return newMsg;
			}

		};

	}
}
