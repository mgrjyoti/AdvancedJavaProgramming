package com.jspiders.studentManagementSystem.djbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentJDBC {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	
	public void openConnection()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/stud", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet !=null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addStudent(int id, String name, String email, long contact, Double fees) {		
		
		try {
			openConnection();
			query="INSERT INTO student values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, contact);
			preparedStatement.setDouble(5, fees);
			int row = preparedStatement.executeUpdate();
			System.out.println(row +" rows affected..." );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
				closeConnection();
			}
		}
}





