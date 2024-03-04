package com.jspiders.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDemo {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args)  {
		
		try {
				connection=openConnection();
				statement=connection.createStatement();
				query=" update  student set age=33 where id=3";
				int row=statement.executeUpdate(query);
				System.out.println(row+ " rows affected");
				
		} catch (Exception e) {
				
		}finally {
			try {
				closeConnection();
				
			} catch (Exception e2) {
				
			}
		}
		
	}

	private static void closeConnection() throws SQLException {
	if (statement !=null) {
		statement.close();
	}
		if (connection !=null) {
			connection.close();
		}
		DriverManager.deregisterDriver(driver);
	}

	private static Connection openConnection() throws SQLException {
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}

}
