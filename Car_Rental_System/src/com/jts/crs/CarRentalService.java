package com.jts.crs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalService {
    private List<Car> cars;
    private List<Customer> customers;
	//private List<Car> optionalCar;
	 private List<BookedCarInformation> bookedCarInformations;
    
    public CarRentalService(){
    	cars= new ArrayList<>();
    	customers = new ArrayList<>();
    	bookedCarInformations = new ArrayList<>();
    }
    
    public void bookedCar(Car car, Customer customer, int days) {
    	if(car.getnoOfAvaliableCar() >0) {
    		car.setnoOfAvaliableCar(car.getnoOfAvaliableCar() - 1);
    		bookedCarInformations.add(new BookedCarInformation(car, customer , days));
    	}
    	else {
    		System.out.println("Car is not available for rent.");
    	}
    }
    
    public void returnCar(Car car ,BookedCarInformation bookedCarInformation) {
    	car.setnoOfAvaliableCar(car.getnoOfAvaliableCar() +1);
    	bookedCarInformations.remove(bookedCarInformation);
    }
    
    public void addCars(Car car) {
    	cars.add(car);
    }
    
    public void addCustomer(Customer cust) {
    	customers.add(cust);
    }
    
    public void options() {
    	Scanner sc= new Scanner(System.in);
    	
    	while(true) {
    		System.out.println("===== Welcome to our Car Rental System =====");
    		System.out.println("1. Rent a Car");
    		System.out.println("2. Return a Car");
    		System.out.println("3. Avaliable Car");
    		System.out.println("4. Exit");
    		
    		System.out.println("Enter your choice");
    		
    		int choice = sc.nextInt();
    		sc.nextLine();
    		
    		if(choice == 1) {
    			System.out.println("== For Renting a Car please provide below details ==");
    			System.out.println("Enter your name: ");
    			
    			String custName = sc.nextLine();
    			
    			System.out.println("Enter the Car ID you want to rent: ");
    			String carId = sc.nextLine();
    			
    			System.out.println("Enter the number of days for rental: ");
    			int days = sc.nextInt();
    			
    			Customer customer = new Customer("CUSTOMER-" + (customers.size() +1), custName);
    			addCustomer(customer);
    			
    			/*cars.stream()
    			.filter(c-> c.getcarId().equalsIgnoreCase(carId) && c.getnoOfAvaliableCar() >0)
    			.findAny(); */
    			
    			Optional<Car> optionalCar = cars.stream()
    				    .filter(c -> c.getcarId().equalsIgnoreCase(carId) && c.getnoOfAvaliableCar() > 0)
    				    .findAny();
    			
    			
    			
				if(optionalCar.isEmpty()) {
    				System.out.println("Car is not available. please try to book another car.");
    				options();
    				return;
    			}
				
				Car selectedCar = optionalCar.get();
				System.out.println("=== Bill Receipt ===");
				System.out.println("Customer ID: "+ customer.getId());
				System.out.println("Customer Name: "+ customer.getName());
				System.out.println("Car Brand: "+ selectedCar.getbrand() + "Model: " + selectedCar.getmodel());
				System.out.println("Rental Days: "+days);
				System.out.println("Total Price: "+selectedCar.calculatePrice(days));
				
				System.out.println("Confirm rental (Y/N):");
				String confirmation = sc.next();
				
				if(confirmation .equalsIgnoreCase("Y")) {
					// Booked a Car
					bookedCar(selectedCar, customer, days);
					System.out.println("Car booking is done successfully.");
				}
				else {
					System.out.println("Car booking is canceled.");
				}
    		}
    		else if(choice == 2) {
    			System.out.println("== Return a Car ==");
    			System.out.println("Enter the car ID you want to return:");
    			String carId = sc.nextLine();
    			
    			Optional<Car> optionalCar = cars.stream()
    					.filter(c -> c.getcarId().equals(carId))
    					.findAny();
    			
    			if(optionalCar.isEmpty()) {
    				System.out.println("please provide valid car details.");
    				options();
    				return;
    			}
    			
    			Car carToReturn = optionalCar.get();
    			
    		BookedCarInformation bookedCarInformation = bookedCarInformations.stream()
    			.filter(b -> b.getCar() == carToReturn).findFirst()
    			.orElse(null);
    		
    		if(bookedCarInformation == null) {
    			System.out.println("Car information not available. please provide valid details.");
    			options();
    			return;
    		}
    		
    		Customer cust = bookedCarInformation.getCustomer();
    		
    		returnCar(carToReturn,bookedCarInformation);
    		System.out.println("Car returned successfuly by" + cust.getName());
    		
    		}
    		else if(choice == 3) {
    			System.out.println("== Available Cars ==");
    			
    			cars.stream()
    			.filter(c -> c.getnoOfAvaliableCar() >0)
    			.forEach(car -> System.out.println(car.getcarId() +" - " + car.getbrand() + " " + car.getmodel() + " " + car.getnoOfAvaliableCar()));
    			
    		} else if(choice == 4) {
    			System.out.println("Thank you for choosing us.");
    			break;
    		}
    		else {
    			System.out.println("Please provide valid options.");
    		}
    		
    	}
    }
}
