package com.jspiders.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class InsertDemo2 {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	public static void main(String[] args)  {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the ID ");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Student Name ");
		String name=scanner.nextLine();
		System.out.println("Enter Student Email ");
		String email=scanner.nextLine();
		System.out.println("Enter Student Age ");
		int age=scanner.nextInt();
		System.out.println("Enter Student Contact ");
		long contact=scanner.nextLong();
		System.out.println("Enter Student Addtess ");
		String address=scanner.nextLine();
		scanner.nextLine();
		scanner.close();
		try {
				connection=openConnection();
				statement=connection.createStatement();
				query="insert into student values("+ id+ ",'"+ name +"', '"+email +"'," + age +" ,"+contact+" ,'" + address +"')";
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
