package com.jts.crs;

public class Car {
   private String carId;
   
   private String brand;
   
   private String model;
   
   private double pricePerDay;
   
   private int noOfAvaliableCar;
   
   
   // get and set....
   
   public String getcarId() {
	   return carId;
   }
   
   public void setcarId(String carId) {
	   this.carId=carId;
   }
   
   public String getbrand() {
	   return brand;
   }
   
   public void setbrand(String brand) {
	   this.brand=brand;
   }
   
   public String getmodel() {
	   return model;
   }
   
   public void setmodel(String model) {
	   this.model=model;
   }
   
   public double getpricePerDay() {
	   return pricePerDay;
   }
   
   public void setpricePerDay(double pricePerDay) {
	   this.pricePerDay=pricePerDay;
   }
   
   public int getnoOfAvaliableCar() {
	   return noOfAvaliableCar;
   }
   
   public void setnoOfAvaliableCar(int noOfAvaliableCar) {
	   this.noOfAvaliableCar=noOfAvaliableCar;
   }
   
   public double calculatePrice(int days) {
	   return pricePerDay *days;
   }
}
