package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }

	public Map<ParkingTicket, Car> getCars() {
		return cars;
	}
	
	public int getCapacity() {
		return capacity;
	}  
	
	
//  通过ticket获得car，则去除该ticket
//	通过ticket获得car，则去除该ticket
	public Car getCarByTicket(ParkingTicket parkingTicket) {
		return cars.remove(parkingTicket);
	}
//  通过停车获取ticket，则添加该ticket
	public void parkCar(ParkingTicket parkingTicket, Car car) {		
		cars.put(parkingTicket, car);
	}
    
}
