package com.jspiders.JDBC1.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo1 {

	private static Connection connection;
	private  static String query;
	private static PreparedStatement statement;
	
	public static void main(String[] args) {
		
		try {
			connection=openConnection();
			query="create database jdbc1";
			statement=connection.prepareStatement(query);
			statement.execute();
			
			
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
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	private static void closeConnection() throws SQLException {
		if (connection!=null ) {
			connection.close();
		}
		if (statement!=null) {
			statement.close();
		}
	}
}








