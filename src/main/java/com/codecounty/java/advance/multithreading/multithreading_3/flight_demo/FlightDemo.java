package com.codecounty.java.advance.multithreading.multithreading_3.flight_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FlightDemo {
	public static void main(String[] args) {
		AirlineContractInterface goAir = new GoAirService();
		AirlineContractInterface indigo = new IndigoService();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Callable<List<FlightDetail>> callable1 = new Callable<List<FlightDetail>>() {
			@Override
			public List<FlightDetail> call() throws Exception {
				return goAir.getFlightDetails("LKO", "DLI");
			}
		};
		
		Callable<List<FlightDetail>> callable2 = new Callable<List<FlightDetail>>() {
			@Override
			public List<FlightDetail> call() throws Exception {
				return indigo.getFlightDetails("LKO", "DLI");
			}
		};
		
		Future<List<FlightDetail>> goFutureList = executorService.submit(callable1);
		Future<List<FlightDetail>> indigoFutureList = executorService.submit(callable2);
		List<FlightDetail> response = new ArrayList<>();
		try {
			response.addAll(indigoFutureList.get(100, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		try {
			response.addAll(goFutureList.get(100, TimeUnit.MILLISECONDS));//100 + 100
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		System.out.println(response);
	}
}