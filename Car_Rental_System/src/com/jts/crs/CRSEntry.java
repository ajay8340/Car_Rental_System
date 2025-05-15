package com.jts.crs;

public class CRSEntry {
   public static void main(String[] args) {
	Car toyotacar = new Car();
	toyotacar.setcarId("CAR-1");
	toyotacar.setbrand("Toyota");
	toyotacar.setmodel("Fortuner");
	toyotacar.setpricePerDay(3000);
	toyotacar.setnoOfAvaliableCar(1);
	
	
	Car tatacar = new Car();
	tatacar.setcarId("CAR-2");
	tatacar.setbrand("Tata");
	tatacar.setmodel("Harier");
	tatacar.setpricePerDay(2500);
	tatacar.setnoOfAvaliableCar(2);
	
	
	Car mahindracar = new Car();
	mahindracar.setcarId("CAR-3");
	mahindracar.setbrand("Mahindra");
	mahindracar.setmodel("XUV 700");
	mahindracar.setpricePerDay(3500);
	mahindracar.setnoOfAvaliableCar(2);
	
	CarRentalService carRentalService = new CarRentalService();
	carRentalService.addCars(toyotacar);
	carRentalService.addCars(tatacar);
	carRentalService.addCars(mahindracar);
	
	carRentalService.options();
}
}
