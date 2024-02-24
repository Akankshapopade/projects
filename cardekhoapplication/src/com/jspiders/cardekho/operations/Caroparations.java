package com.jspiders.cardekho.operations;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.cardekho.entity.Car;

//import com.jspiders.cardekho.entity.Car;

public class Caroparations {
ArrayList<Car> cars=new ArrayList<>();
	
	//to call viewAllCar method
	public void viewAllCar(Scanner scanner) {
		for(Car car:cars) {
			System.out.println(car);
		}
	}
	public void addCar(Scanner scanner) {
		Car car=new Car();
		System.out.println("Enter car id");
		int id=scanner.nextInt();
		car.setId(id);
		scanner.nextLine();
		System.out.println("Enter car name");
		String name=scanner.nextLine();
		car.setName(name);
		System.out.println("Enter car brand");
		String brand=scanner.nextLine();
		car.setBrand(brand);
		System.out.println("Enter car fuel type");
		String ftype=scanner.nextLine();
		car.setFueltype(ftype);
		System.out.println("Enter a car price");
		double price=scanner.nextDouble();
		car.setPrice(price);
		System.out.println("Enter car color");
		String color=scanner.nextLine();
		car.setColor(color);
		cars.add(car);
		System.out.println("Car added");
	}
	public void searchCar(Scanner scanner){
		boolean flag=false;
		System.out.println("Enter car id");
		scanner.nextLine();
		
		int id=scanner.nextInt();
		for(Car car:cars) {
			if(car.getId()==id) {
				System.out.println(car);
				flag=true;
				break;
			}
		}
		if(!flag) {
			System.out.println("Car not found");
		}
	}
	public void fetchAllCars() {
		boolean flag=false;
			for(Car car:cars) {
				if(cars.size()>0) {
				System.out.println(car);
				break;
			}
		}
			if(!flag) {
				System.out.println("Car not found");
			}

	}
	
	public void removeCar(Scanner scanner) {
		boolean flag=false;
		System.out.println("Enter car id");
		int id=scanner.nextInt();
		for(Car car:cars) {
			if(car.getId()==id) {
				flag=true;
				cars.remove(car);//Overloaded method
				System.out.println("Car deleted");
				break;
				
			}
			}
		if(!flag) {
			System.out.println("Car Not Found");
		}
	}
	public  void editCar(Scanner scanner){
		boolean flag=false;
		System.out.println("Enter car id");
		int id=scanner.nextInt();
		for(Car car:cars) {
			if(car.getId()==id) {
				flag=true;	
				System.out.println("Enter new price");
				double price=scanner.nextDouble();
				car.setPrice(price);
				System.out.println("Car Has Updated");
			}
		}
		if(!flag) {
			System.out.println("Car Not Found");
		}
	}
	}

