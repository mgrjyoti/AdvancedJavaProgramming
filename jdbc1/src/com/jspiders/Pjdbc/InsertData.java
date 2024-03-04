package com.jspiders.Pjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) {
		try {
			connection=openConnection();
			statement=connection.createStatement();
			query="insert into student values(3,'Pranita Magar', 'pranitamagar@gmail.com',18,99356825346,'Pangri')";
			int row=statement.executeUpdate(query);
			System.out.println(row+ "rows affected..");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/copy", "root","root");
	}
	public static void closeConnection() throws SQLException {
	
		if (connection!=null) {
			connection.close();
		}
		if (statement !=null) {
			statement.close();
		}
		if (resultSet !=null) {
			resultSet.close();
		}
	}
}
