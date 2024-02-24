package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Task1 {
	private static Connection connection;
	  private static Statement statement;
	  private static String query;
	  public static void main(String[] args) {
			try {
				openConnection();
				statement=connection.createStatement();
				query="INSERT INTO student VALUES(1,'ramesh','ramesh@gmail.com',23)";
				statement.execute(query);
				System.out.println("data inserted");
				query="INSERT INTO student VALUES(2,'suresh','suresh@gmail.com',24)";
				statement.execute(query);
				System.out.println("data inserted");
				query="INSERT INTO student VALUES(3,'ganesh','ganesh@gmail.com',22)";
				statement.execute(query);
				System.out.println("data inserted");
				query="INSERT INTO student VALUES(4,'ajay','ajay@gmail.com',21)";
				statement.execute(query);
				System.out.println("data inserted");
				query="INSERT INTO student VALUES(5,'vijay','vijay@gmail.com',20)";
				statement.execute(query);
				System.out.println("data inserted");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					closeConnection();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		  private static void openConnection() throws SQLException {
			  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
			  
		  }
		  private static void closeConnection() throws SQLException {
			if (statement!=null) {
				statement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		  }
}
