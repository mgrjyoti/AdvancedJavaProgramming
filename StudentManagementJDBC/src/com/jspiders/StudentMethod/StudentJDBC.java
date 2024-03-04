package com.jspiders.StudentMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentJDBC {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	StudentData studentData=new StudentData();
	
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
		private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}	
		if (resultSet !=null) {
			resultSet.close();
		}
	}
	
	public void addStudent() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter student id ");
		studentData.setId(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter student Name ");
		studentData.setName(scanner.nextLine());
		System.out.println("Enter student Email ");
		studentData.setEmail(scanner.nextLine());
		System.out.println("Enter Student Age ");
		studentData.setAge(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter Student Contact ");
		studentData.setContact(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter Student Address ");
		studentData.setAddress(scanner.nextLine());
		scanner.close();
		
		try {
			   connection=openConnection();
			query="insert into student1 values(?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);							
					preparedStatement.setInt(1,studentData.getId() );
					preparedStatement.setString(2, studentData.getName());
					preparedStatement.setString(3, studentData.getEmail());
					preparedStatement.setInt(4,studentData.getAge() );
					preparedStatement.setLong(5, studentData.getContact());
					preparedStatement.setString(6, studentData.getAddress());
					int row=preparedStatement.executeUpdate();
					System.out.println(row +" rows Affected...");		

		} catch (ClassNotFoundException | SQLException e) {	
		e.printStackTrace();
		}finally {
		try {
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
	

	public void updateStudent() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student id which you want to update...");
		int id=scanner.nextInt();
		System.out.println("Enter student name ");
		String name=scanner.nextLine();
		scanner.close();
		try {
			connection =openConnection();
			query="update student set name=? where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			int row=preparedStatement.executeUpdate();
			
			System.out.println(row +" rows affected");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	public void removeStudent() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student id which you want to delete..");
		int id=scanner.nextInt();
        scanner.close();
		try {
			openConnection();
			query="delete from student1 where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row=scanner.nextInt();
			System.out.println(row+" rows affected.");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
		
}
































