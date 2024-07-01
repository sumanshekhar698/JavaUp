package com.codecounty.java.advance.multithreading.multithreading_3.flight_demo;

import java.util.List;

public interface AirlineContractInterface {

    List<FlightDetail> getFlightDetails(String src, String dest);
}
