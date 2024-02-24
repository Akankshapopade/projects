package com.jspiders.cardekhojdbc.menu;

import java.util.Scanner;

import com.jspiders.cardekhojdbc.operations.CarOperations;
import com.jspiders.cardekhojdbc.register.RegisterCar;

public class CarMenu {
	static Scanner scanner = new Scanner(System.in);
	static CarOperations operations = new CarOperations();
	public static void main(String[] args)  {
		
		 
		
		boolean flag= true;
		while(flag) {
			System.out.println("Enter choice\n"
					+"Enter 1 to singUp\n"
					+"Enter 2 to login\n"
					+"Enter 3 to exit\n");
			int choice = scanner.nextInt();
			switch(choice) {
			
			case 1:
				RegisterCar.signUp(scanner);
				break;
			case 2:
				RegisterCar.login(scanner);
				carApp(scanner);
				break;
			case 3:
				flag=false;
				System.out.println("Thank You");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	
	}
	
	private static void carApp(Scanner scanner) {
		boolean loop = true;
		while (loop) {
			System.out.println("========MainMenu=======\n" 
			        + "1. view all cars\n" 
					+ "2. search car\n" + "3. add car\n"
					+ "4. remove Car\n" + "5. edit Car\n" 
					+ "6. exit");
			
			int choice =scanner.nextInt();
			switch (choice) {
			case 1:
				operations.viewAllCars();
				break;
			case 2:
				operations.searchByCars();
				break;
			case 3:
				operations.addCars();
				break;
			case 4:
				operations.removeCars();
				break;
			case 5:
				operations.editCars();
				break;
			case 6:
				loop = false;
				System.out.println("You can exit Now");
				System.out.println("Thank You");
				break;
			default:
				System.out.println("Invalid MainMenu choice please enter another");
			}
		}

	}
}
