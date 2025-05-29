package dev.codecounty.java.java8.advance.multithreading.jakob_jenkov.executors;

import java.util.List;
import java.util.concurrent.*;

public class _4ThreadPoolExecutorSeviceInvokeAnyCallable {// Used to create customized thread pool
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// Internally ThreadPool, create a Future and connects it to the corresponding
		// task internally, the future is returned to the Parent therad even before
		// execution

		List<Callable<String>> listOfCallables = List.of(newCallable("Hi"), newCallable("Hey"),
				newCallable("Namaste"), newCallable("Moshi Mosi"));

		try {
			// invokeAny() returns the result of any 1st successful operation which got executed,
			// rest waiting tasks are canceled, you should not modify the collection during
			// the invokeAny, it can be use to get the quickest response from multile
			// services, inthgis case the fastest service will be considered
			String result = executorService.invokeAny(listOfCallables);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

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
