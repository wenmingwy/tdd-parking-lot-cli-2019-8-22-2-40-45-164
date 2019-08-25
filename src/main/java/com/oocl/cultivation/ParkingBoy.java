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
    		this.lastErrorMessage = "The parking lot is full.";
    		return null;
    	}
    	this.lastErrorMessage = null;
//		有空位则进行更新匹配
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingLot.parkCar(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
//    	票为空，无法提车
    	if(ticket == null) {
    		this.lastErrorMessage = "Please provide your parking ticket.";
    		return null;
    	}
//    	凭票进行提车
    	Car car = parkingLot.getCarByTicket(ticket);
//    	车票无法识别的情况
    	if(car == null) {
    		this.lastErrorMessage = "Unrecognized parking ticket.";
    		return null;
    	}
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
