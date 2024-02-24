package com.jspiders.cardekho.menu;

import java.util.Scanner;

import com.jspiders.cardekho.operations.Caroparations;

public class Carmenu {
	private static Caroparations cardekho= new Caroparations();//import package (control+shift+o)
	static boolean flag = true;
	public static void mainMenu() {
		System.out.println("======MENU======\n" + "1.View All Cars\n" + "2.Search Car\n" + "3.Add Car\n"
				+ "4.Remove Car\n" + "5.Edit Car\n" + "6.Exit\n");
		Scanner scanner = new Scanner(System.in);
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("====Main Menu==="+"");
			//trying to access non static into static main method to overcome we have to make object as a private and static i.e line no 8
			cardekho.viewAllCar(scanner); 
			break;
		case 2:		
			cardekho.searchCar(scanner);
			break;
		case 3:
			cardekho.addCar(scanner);
			break;
		case 4:
			cardekho.removeCar(scanner);
			break;
		case 5:
			cardekho.editCar(scanner);
			break;
		case 6:
			cardekho.fetchAllCars();
			break;
		case 7:
			flag=false;
			System.out.println("Thank You For Visit...!!");
			break;
			
		default:
			System.out.println("Invalid Choice...!!!");
			break;
		}
	}

	public static void main(String[] args) {
		
	while (flag) {
		mainMenu();
	}
	
	}
}
