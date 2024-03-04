package com.jspiders.Pjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertDemo2 {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Stdent ID.");
		int id=scanner.nextInt();
	connection=openConnection();
	query="Select * from student where id= 2";
	preparedStatement= connection.prepareStatement(query);
	resultSet=preparedStatement.executeQuery();
	while (resultSet.next()) {
		System.out.println( resultSet.getInt(1) +" | |"
							+ resultSet.getString(2)+" | |"
							+ resultSet.getString(3) +" | |"
							+ resultSet.getInt(4) +" | |"
							+ resultSet.getLong(5) +" | |"
							+ resultSet.getString(6));
	}
	
	}
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/copy", "root", "root");
		
	}
	public static void closeConnection() throws SQLException {
		if (resultSet!=null) {
			resultSet.close();
		}
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (connection!=null) {
			connection.close();
		}
	}
}

















