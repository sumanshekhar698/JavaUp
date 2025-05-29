package dev.codecounty.java.questions.lld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionParkingLot implements Q001ParkingLotInterface {
    private ParkingFloor floors[];
    private SearchManager searchManager;

    Set<Integer> vehicleTypes = new HashSet<>(Arrays.asList(2, 4));
    private Helper01 helper;

//    public Solution() {
//    }

    public void init(Helper01 helper, String[][][] parking) {//initialising the SOlution Class
        this.helper = helper;
        floors = new ParkingFloor[parking.length];//no of floors in the parking building

        for (int floor = 0; floor < parking.length; floor++) {
            ParkingSpot[][] spots = getParkingSpots(floor, parking[floor]);
            floors[floor] = new ParkingFloor(spots, vehicleTypes);
        }
        searchManager = new SearchManager();
    }

    /**
     * ParkingResult status 201 for success,  404 for failure
     * vehicleType = 2 or 4 for 2-wheeler or 4-wheeler vehicle
     */
    public ParkingResult park(int vehicleType, String vehicleNumber, String ticketId) {
        if (!vehicleTypes.contains(vehicleType) ||
                (vehicleNumber.isEmpty() && ticketId.isEmpty()))
            return new ParkingResult(404, "", "", "");
        for (ParkingFloor floor : floors) {
            ParkingResult result = floor.park(vehicleType, vehicleNumber, ticketId);
            if (result != null && result.getStatus() == 201) {
                searchManager.index(result);
                return result;
            }
        }
        return new ParkingResult(404, "", vehicleNumber, ticketId);
    }

    /**
     * - 201 success, 404 : vehicle not found or any other error,
     * - exactly one of spotId, vehicleNumber or ticketId will be non empty
     */
    public int removeVehicle(String spotId, String vehicleNumber, String ticketId) {
        // extracting floor, row, column of parking spot where vehicle is parked
        ParkingResult search = searchVehicle(spotId, vehicleNumber, ticketId);
        if (search == null || search.getStatus() >= 400) return 404;
        Integer[] location = helper.getSpotLocation(search.getSpotId());
        int floor = location[0], row = location[1], col = location[2];
        if (floor < 0 || floor >= floors.length) return 404;
        return floors[floor].removeVehicle(row, col);
    }

    /**
     * status = 200 : success, 404 : not found
     * exactly one of spotId, vehicleNumber or ticketId will be non-empty
     */
    public ParkingResult searchVehicle(String spotId, String vehicleNumber, String ticketId) {
        return searchManager.searchVehicle(spotId, vehicleNumber, ticketId);
    }

    // floor is 0-index based, i.e.  0<=floor<parking.length
    // vehicleType = 2 or 4 for 2-wheeler or 4-wheeler vehicle
    public int getFreeSpotsCount(int floor, int vehicleType) {
        if (floor < 0 || floor >= floors.length) return 0;
        return floors[floor].freeSpotsCount(vehicleType);
    }


    /*Converts a 2D array of String into a class based actual parking spot
    parking = [[
["4-1","4-1","2-1","2-0"],
["2-1","4-1","2-1","2-1"],
["4-0","2-1","4-0","2-1"],
["4-1","4-1","4-1","2-1"]]]
    * */
    private ParkingSpot[][] getParkingSpots(int floor, String rows[][]) {
        ParkingSpot[][] spots = new ParkingSpot[rows.length][rows[0].length];
        for (int row = 0; row < rows.length; row++) {
            for (int col = 0; col < rows[row].length; col++) {
                String spot = rows[row][col];
                if (spot.equals("2-1")) {
                    spots[row][col] = new ParkingSpot(
                            helper.getSpotId(floor, row, col), 2);
                } else if (spot.equals("4-1")) {
                    spots[row][col] = new ParkingSpot(
                            helper.getSpotId(floor, row, col), 4);
                }
            }
        }
        return spots;
    }

}

class ParkingFloor {
    //vehicleType vs free spots map
    // it improves the complexity of park method from o(row*col) to o(1)
    private HashMap<Integer, ConcurrentLinkedDeque<ParkingSpot>> freeSpots;

    // vehicleType vs freeSpots size map
    private HashMap<Integer, AtomicInteger> freeSpotsSize;//<VehicleType in int, noOfSpots>

    private ParkingSpot allSpots[][];

    ParkingFloor(ParkingSpot[][] spots, Set<Integer> vehicleTypes) {//spots is a 2D array of all the spos in a floor
        this.allSpots = spots;
        freeSpots = new HashMap<>();
        freeSpotsSize = new HashMap<>();
        // initialize lists for each vehicle types and their corresponding sizes
        for (int vehicleType : vehicleTypes) {
            freeSpots.put(vehicleType, new ConcurrentLinkedDeque<>());
            freeSpotsSize.put(vehicleType, new AtomicInteger(0));
        }

        for (ParkingSpot[] rows : spots)
            // add spots to lists of respective vehicle type and increment size of list
            for (ParkingSpot spot : rows)
                if (spot != null) {
                    freeSpots.get(spot.getVehicleType()).add(spot);
                    freeSpotsSize.get(spot.getVehicleType()).addAndGet(1);
                }

    }


    public ParkingResult park(int vehicleType, String vehicleNumber, String ticketId) {
        AtomicInteger size = freeSpotsSize.get(vehicleType);
        boolean canPark = false;
        // check if we can get a parking spot on this floor
        while (true) {
            int old = size.get();
            if (old <= 0) return new ParkingResult(404, "", vehicleNumber, ticketId);
            if (size.compareAndSet(old, old - 1)) {
                canPark = true;
                break;
            }
        }
        if (canPark) {
            // remove first free spot from list of given vehicle type in o(1)
            ParkingSpot spot = freeSpots.get(vehicleType).remove();
            spot.setVehicleNumber(vehicleNumber);
            spot.setTicketId(ticketId);
            return new ParkingResult(201, spot.getSpotId(), vehicleNumber, ticketId);
        }

        return new ParkingResult(404, "", vehicleNumber, ticketId);
    }

    /**
     * - 201 success, 404 : vehicle not found or any other error,
     */
    public int removeVehicle(int row, int col) {
        if (row < 0 || row >= allSpots.length || col < 0 || col >= allSpots[0].length) return 404;
        ParkingSpot spot = allSpots[row][col];
        if (spot.getVehicleNumber().isEmpty() && spot.getTicketId().isEmpty()) return 404;
        spot.setTicketId("");
        spot.setVehicleNumber("");
        freeSpots.get(spot.getVehicleType()).add(spot);
        freeSpotsSize.get(spot.getVehicleType()).addAndGet(1);
        return 201;
    }

    int freeSpotsCount(int vehicleType) {
        if (!freeSpotsSize.containsKey(vehicleType)) return 0;
        return freeSpotsSize.get(vehicleType).get();
    }

}

class SearchManager {
    private ConcurrentHashMap<String, ParkingResult> cache = new ConcurrentHashMap<>();

    void index(ParkingResult result) {   // add prefixes to indiacate whether its spotId or vehicleId or ticketId
        cache.put("s>" + result.getSpotId(), result);
        cache.put("v>" + result.getVehicleNumber(), result);
        cache.put("t>" + result.getTicketId(), result);
    }

    public ParkingResult searchVehicle(String spotId, String vehicleNumber, String ticketId) {
        if (spotId.trim().length() > 0) return cache.get("s>" + spotId);
        if (vehicleNumber.trim().length() > 0) return cache.get("v>" + vehicleNumber);
        if (ticketId.trim().length() > 0) return cache.get("t>" + ticketId);
        return new ParkingResult(404, spotId, vehicleNumber, ticketId);
    }

}

class ParkingSpot {
    private String spotId;
    private int vehicleType;

    private String vehicleNumber, ticketId;

    ParkingSpot(String spotId, int vehicleType) {
        this.spotId = spotId;
        this.vehicleType = vehicleType;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getVehicleType() {
        return vehicleType;
    }
}

// uncomment below code in case you are using your local ide and
// comment it back again back when you are pasting completed solution in the online codezym editor
// this will help avoid unwanted compilation errors and get method autocomplete in your local code editor.

class ParkingResult {
    private int status;
    private String spotId, vehicleNumber, ticketId;

    ParkingResult(int status, String spotId, String vehicleNumber, String ticketId) {
        this.status = status;
        this.spotId = spotId;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
    }

    public int getStatus() {
        return status;
    }

    public String getSpotId() {
        return spotId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getTicketId() {
        return ticketId;
    }
}

interface Q001ParkingLotInterface {
    void init(Helper01 helper, String[][][] parking);

    ParkingResult park(int vehicleType, String vehicleNumber, String ticketId);

    int removeVehicle(String spotId, String vehicleNumber, String ticketId);

    ParkingResult searchVehicle(String spotId, String vehicleNumber, String ticketId);

    int getFreeSpotsCount(int floor, int vehicleType);
}

class Helper01 {
    void print(String s) {
        System.out.print(s);
    }

    void println(String s) {
        print(s + "\n");
    }

    String getSpotId(int floor, int row, int column) {
        return "" + floor + "-" + row + "-" + column;
    }

    Integer[] getSpotLocation(String spotId) {
        Integer[] location = {-1, -1, -1};
        String[] ss = spotId.split("-");
        for (int i = 0; i < 3 && i < ss.length; i++) {
            location[i] = Integer.parseInt(ss[i]);
        }
        return location;
    }
}
