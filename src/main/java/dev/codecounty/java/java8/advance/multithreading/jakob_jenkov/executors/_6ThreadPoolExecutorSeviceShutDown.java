package dev.codecounty.java.java8.advance.multithreading.jakob_jenkov.executors;

import java.util.List;
import java.util.concurrent.*;

public class _6ThreadPoolExecutorSeviceShutDown {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		List<Callable<String>> listOfCallables = List.of(newCallable("Hi"), newCallable("Hey"),
				newCallable("Namaste"), newCallable("Moshi Mosi"));

		// invokeAll() returns a List<Future> result which holds the Future for all the
		// submitted task inOrder of the supplied collection
		List<Future<String>> results;
		try {
			results = executorService.invokeAll(listOfCallables);
			// System.out.println(results);
			// results.forEach(future -> {
			// try {
			// System.out.println(future.get());// As usual get blocks the thread
			// } catch (InterruptedException | ExecutionException e) {
			// e.printStackTrace();
			// }
			// });
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		;

		// executorService.shutdown();// this shutdown() waits for all the threads to be
		// completed
		List<Runnable> list = executorService.shutdownNow();
		System.out.println(list);
		// shutdownNow()
		// taskInExecution :: will attemt to stop all the task in excution, but there is
		// not guarantee that it will be able to do
		// awaitingTask :: it will return the runnables for all the task that were
		// awaiting execution
		// !!! There is no guarantee that the Executors will terminate, even and after the
		// method returned, Still some task may be running
 
		try {
			boolean ops = executorService.awaitTermination(3000L, TimeUnit.MILLISECONDS);/// it blocks the thread after
																							/// shutDownNow() for the
																							/// given time for the last
																							/// bunch of task to be
																							/// completed
			System.out.println(ops);// true is terminated | false if timout elapsed before termination
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
