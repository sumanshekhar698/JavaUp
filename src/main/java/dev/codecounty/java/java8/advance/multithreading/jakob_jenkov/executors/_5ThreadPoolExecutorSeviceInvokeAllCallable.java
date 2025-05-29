package dev.codecounty.java.java8.advance.multithreading.jakob_jenkov.executors;

import java.util.List;
import java.util.concurrent.*;

public class _5ThreadPoolExecutorSeviceInvokeAllCallable {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Callable<String>> listOfCallables = List.of(newCallable("Hi"), newCallable("Hey"),
				newCallable("Namaste"), newCallable("Moshi Mosi"));

		// invokeAll() returns a List<Future> result which holds the Future for all the
		// submitted task inOrder of the supplied collection
		List<Future<String>> results;
		try {
			results = executorService.invokeAll(listOfCallables);
			System.out.println(results);
			results.forEach(future -> {
				try {
					System.out.println(future.get());// As usual get blocks the thread
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		;

		executorService.shutdown();

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
