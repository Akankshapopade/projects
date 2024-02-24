package com.jspiders.cardekhojdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CarOperations {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static String query1;
	private static ResultSet resultSet;

	Scanner scanner = new Scanner(System.in);

	public void viewAllCars() {
		try {
			openConnection();
			statement = connection.createStatement();
			query = "Select * from cardekho ";
			resultSet = statement.executeQuery(query);

			int count = 0;
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "  ");
				System.out.print(resultSet.getString(2) + "  ");
				System.out.print(resultSet.getString(3) + "  ");
				System.out.print(resultSet.getString(4) + "  ");
				System.out.print(resultSet.getDouble(5) + " ");
				System.out.print(resultSet.getString(6) + "  ");
				System.out.print(resultSet.getString(7) + "  ");
				System.out.println();
				count++;
			}
			System.out.println(count + " car(s) Found");
			if (count == 0) {
				System.out.println("Cars Not Available");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	public void searchByCars() {

		try {

			System.out.println("========Search Car Menu=======\n" + "1. search by id\n" + "2. search by name\n"
					+ "3. Search by brand\n" + "4. Search by color\n" + "5. Search by price\n"
					+ "6. Search by fueltype\n");
			System.out.println("Enter choice to search car");
			int choice = scanner.nextInt();

			openConnection();

			switch (choice) {
			case 1:
				System.out.print("Enter the id  ");
				int id = scanner.nextInt();
				query = "select * from cardekho where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				display();
				break;
			case 2:
				System.out.println("Enter the Name");
				String name = scanner.next();
				query = "select * from cardekho where name = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				display();
				break;
			case 3:
				System.out.println("Enter the brand");
				String brand = scanner.next();
				query = "select * from cardekho where brand = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, brand);
				display();
				break;
			case 4:
				System.out.println("Enter the Color");
				String color = scanner.next();
				query = "select * from cardekho where color = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, color);
				display();
				break;
			case 5:
				System.out.println("Enter the minPrice");
				String minPrice = scanner.next();
				System.out.println("Enter the maxPrice");
				String maxPrice = scanner.next();
				query = "select * from cardekho where price between ? and ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, minPrice);
				preparedStatement.setString(2, maxPrice);
				display();
				break;
			case 6:
				System.out.println("Enter the FuelType");
				String fueltype = scanner.next();
				query = "select * from cardekho where fuelType = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, fueltype);
				display();
				break;
			default:
				System.out.println("Invalid choice");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void display() throws SQLException {
		resultSet = preparedStatement.executeQuery();
		int count = 0;
		while (resultSet.next()) {

			System.out.print(resultSet.getInt(1) + "  ");
			System.out.print(resultSet.getString(2) + "  ");
			System.out.print(resultSet.getString(3) + "  ");
			System.out.print(resultSet.getString(4) + "  ");
			System.out.print(resultSet.getDouble(5) + "  ");
			System.out.print(resultSet.getString(6) + "  ");
			System.out.print(resultSet.getString(7) + "  ");
			System.out.println();
			count++;
		}
		System.out.println(count + " Car(s) found");
		if (count == 0) {
			System.out.println("Not found car");
		}
	}

	public void addCars() {

		try {
			openConnection();
			query = "insert into cardekho values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("\nHow Many Cars you want to add?");
			int choice = scanner.nextInt();

			for (int i = 1; i <= choice; i++) {
				System.out.println("Enter id: ");
				int id = scanner.nextInt();
				System.out.println("Enter Name: ");
				String name = scanner.next();
				System.out.println("Enter Brand: ");
				String brand = scanner.next();
				System.out.println("Enter Color: ");
				String color = scanner.next();
				scanner.nextLine();
				System.out.println("Enter Price: ");
				double price = scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter Model: ");
				String model = scanner.next();
				scanner.nextLine();
				System.out.println("Enter FuelType: ");
				String fuelType = scanner.next();

				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, brand);
				preparedStatement.setString(4, color);
				preparedStatement.setDouble(5, price);
				preparedStatement.setString(6, model);
				preparedStatement.setString(7, fuelType);
				preparedStatement.addBatch();
			}
			int[] res = preparedStatement.executeBatch();
			System.out.println(res.length + "Car(s) Added");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeCars() {
		try {
			openConnection();
			System.out.println("Enter Car Id to remove Car");
			int id = scanner.nextInt();

			query = "delete from cardekho where id = ?";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, id);

			int res = preparedStatement.executeUpdate();
			if (res == 1) {
				System.out.println("Car deleted");
			} else {
				System.out.println("Car not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editCars() {
		try {
			openConnection();
			System.out.println("Enter car Id to Edit Car");
			int id = scanner.nextInt();

			query = "Select * from cardekho where id =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				display();

				System.out.println("Enter choice to edit Car\n" + "1. name\n" + "2. brand\n" + "3. model\n"
						+ "4. price\n" + "5. fuelType");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter new name to edit car");
					String name = scanner.next();
					query1 = "Update cardekho set name = ? where id =?";
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setInt(2, id);
					preparedStatement.setString(1, name);
					int res = preparedStatement.executeUpdate();
					if (res == 1) {
						System.out.println("Name updated");
					}
					break;
				case 2:
					System.out.println("Enter new Brand to edit car");
					String brand = scanner.next();
					query1 = "Update cardekho set brand = ? where id =?";
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setInt(2, id);
					preparedStatement.setString(1, brand);
					int resBrand = preparedStatement.executeUpdate();
					if (resBrand == 1) {
						System.out.println("Brand updated");
					}
					break;
				case 3:
					System.out.println("Enter new model to edit car");
					String model = scanner.next();
					query1 = "Update cardekho set model = ? where id =?";
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setInt(2, id);
					preparedStatement.setString(1, model);
					int resModel = preparedStatement.executeUpdate();
					if (resModel == 1) {
						System.out.println("Model updated");
					}
					break;
				case 4:
					System.out.println("Enter new Price to edit car");
					int price = scanner.nextInt();
					query1 = "Update cardekho set price = ? where id =?";
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setInt(2, id);
					preparedStatement.setInt(1, price);
					int resPrice = preparedStatement.executeUpdate();
					if (resPrice == 1) {
						System.out.println("Price updated");
					}
					break;
				case 5:
					System.out.println("Enter new FuelType to edit car");
					String fuelType = scanner.next();
					query1 = "Update cardekho set fuelTye = ? where id =?";
					preparedStatement = connection.prepareStatement(query1);
					preparedStatement.setInt(2, id);
					preparedStatement.setString(1, fuelType);
					int resFuel = preparedStatement.executeUpdate();
					if (resFuel == 1) {
						System.out.println("FuelType updated");
					}
					break;
				default:
					System.out.println("Enter invalid choice");

				}
			} else {
				System.out.println("Car not available");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
	}

	
}
