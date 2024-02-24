package com.jspiders.jdbc.operations;

import java.util.Scanner;

public class JDBCServicesMain {
public static void main(String[] args) {
	boolean flag=true;
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter 1 to sign up\n enter 2 to log in \n enter 3 to exit");
	int choice =scanner.nextInt();
	while (flag) {
		switch (choice) {
		case 1:
			JDBCServices.signUp(scanner);
			break;
		case 2:
			JDBCServices.logIn(scanner);
			break;
		case 3:
			flag=false;
			System.out.println("Thank You");
			break;
		default:
			System.out.println("invlid choice");
			break;
		}
	}
}
}
