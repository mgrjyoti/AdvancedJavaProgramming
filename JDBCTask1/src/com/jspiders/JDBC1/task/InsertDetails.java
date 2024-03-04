package com.jspiders.JDBC1.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDetails {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			
			connection=openConnection();
			Scanner scanner=new Scanner(System.in);
			System.out.println("How many Student you want to add? ");
			int how=scanner.nextInt();
			for (int i = 1; i <=how; i++) {
				System.out.println("Enter Student id.");
				int id=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Student Name.");
				String name=scanner.nextLine();
				System.out.println("Enter Student Email.");
				String email=scanner.nextLine();
				System.out.println("Enter Student Age.");
				int age=scanner.nextInt();
				System.out.println("Enter Student Fees.");
				double fees=scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Enter Student Address");
				String address=scanner.nextLine();
				
			query="insert into student3 values(?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, age);
			preparedStatement.setDouble(5,fees );
			preparedStatement.setString(6, address);
			int row=preparedStatement.executeUpdate();
			System.out.println(row +" rows updates");

			}
			scanner.close();

			
		} catch (ClassNotFoundException | SQLException e) {
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
