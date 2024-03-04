package com.jspiders.JDBC1.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFees {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		try {
			connection=openConnection();
			query=" update student3 set fees=35000 where fees>40000";
			preparedStatement=connection.prepareStatement(query);
			int row=preparedStatement.executeUpdate();
			System.out.println(row+" rows affected...");
			
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
