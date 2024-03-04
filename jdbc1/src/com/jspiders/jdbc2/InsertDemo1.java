package com.jspiders.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo1 {

	private static PreparedStatement pePreparedStatement;
	private static Statement statement;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student Id.");
		int id= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Student Name.");
		String name=scanner.nextLine();
		System.out.println("Enter Student Email.");
		String email=scanner.nextLine();
		System.out.println("Enter Student Age.");
		int age=scanner.nextInt();
		System.out.println("Enter Student Contact.");
		long contact=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter Student Address.");
		String address=scanner.nextLine();
		scanner.close();
		try {
			connection=openConnection();
			preparedStatement=connection.prepareStatement("insert into student1 values (?,?,?,?,?,?)" );
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, age);
			preparedStatement.setLong(5, contact);
			preparedStatement.setString(6, address);
			int row=preparedStatement.executeUpdate();
			System.out.println(row +" rows updates");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3", "root", "root");
	}
	
	public static void closeConnection() {
		
	}
}
