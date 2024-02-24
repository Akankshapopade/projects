package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate2 {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter id of the user");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter new password");
		String password=scanner.nextLine();
		scanner.close();
		try {
			openConnection();
			query="UPDATE user SET password='?' WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, id);
			int res=preparedStatement.executeUpdate();
			if (res==1) {
				System.out.println("password updated");
				System.out.println(res + "row(s) affected");
			} else {
                System.out.println("user not found");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void openConnection() throws SQLException {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}
	private static void closeConnection() throws SQLException {
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}
}
