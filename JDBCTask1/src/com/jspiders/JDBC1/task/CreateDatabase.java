package com.jspiders.JDBC1.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDatabase {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		try {
			connection=openConnection();
			query="create database demo12";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
	
	private static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");
	}
	private static void closeConnection() throws SQLException {
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
		if (connection !=null) {
			connection.close();
		}
	}

}
