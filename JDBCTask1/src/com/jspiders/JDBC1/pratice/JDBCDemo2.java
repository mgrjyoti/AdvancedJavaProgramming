package com.jspiders.JDBC1.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo2 {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			connection=openConnection();
			query="create table data(id int(10)primary key not null,'name' varchar(30)not null, 'email' varchar(50)not null, age int(5)not null, contact long not null, 'address' varchar(30)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1","root","root");
		 
	}
	private static void closeConnection() throws SQLException {
		if (connection!=null) {
			connection.close();
		}
		if (preparedStatement !=null) {
			preparedStatement.close();
		}
	}
}
