package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
//    	没有停车位的时候给出提示null的信息
    	if(parkingLot.getAvailableParkingPosition() == 0) {
     		return null;
    	}
 //		有空位则进行更新匹配
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingLot.parkCar(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {	
//    	凭票进行提车
    	Car car = parkingLot.getCarByTicket(ticket);
    	return  car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
